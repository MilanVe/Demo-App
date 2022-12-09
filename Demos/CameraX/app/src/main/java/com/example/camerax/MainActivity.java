package com.example.camerax;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.camera.camera2.interop.Camera2CameraControl;
import androidx.camera.camera2.interop.Camera2Interop;
import androidx.camera.camera2.interop.ExperimentalCamera2Interop;
import androidx.camera.core.Camera;
import androidx.camera.core.CameraControl;
import androidx.camera.core.CameraSelector;
import androidx.camera.core.ExposureState;
import androidx.camera.core.ImageAnalysis;
import androidx.camera.core.ImageCapture;
import androidx.camera.core.ImageProxy;
import androidx.camera.core.Preview;
import androidx.camera.lifecycle.ProcessCameraProvider;
import androidx.camera.view.PreviewView;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;


import androidx.lifecycle.LifecycleOwner;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.ImageFormat;
import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CaptureRequest;
import android.media.Image;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.util.Range;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.common.util.concurrent.ListenableFuture;
import java.io.ByteArrayOutputStream;
import java.nio.ByteBuffer;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import com.util.*;


public class MainActivity extends AppCompatActivity {

    private final Executor executor = Executors.newSingleThreadExecutor();
    private final int REQUEST_CODE_PERMISSIONS = 100;
    private final int Hue_Queue_length = 1000;
    private final int Pixels_per_line = 50;
    private final int Pixels_per_column = 50;
    private final String[] REQUIRED_PERMISSIONS = new String[]{"android.permission.CAMERA", "android.permission.WRITE_EXTERNAL_STORAGE"};
//TODO check if this is the right location
    private final AnalyticQueue hueValues = new AnalyticQueue(Hue_Queue_length);
    PreviewView previewView;
    ImageView captureImage;
    TextView tv1;
    Button button;
    Boolean recording = false;
    //TextView text = findViewById(R.id.text);

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        previewView = findViewById(R.id.camera);

        //captureImage = findViewById(R.id.captureImg);

        tv1 = findViewById(R.id.text);
        tv1.setText("checkpoint 42");
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if (recording) {
                    recording = false;
                    button.setText("Start");
                } else {
                    recording = true;
                    button.setText("Stop");
                }
            }
        });

        /** Camera start and permission  **/
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
        {   //No permission
            if (ActivityCompat.shouldShowRequestPermissionRationale(this, Manifest.permission.CAMERA))
            {   //??
            }
            else
            {   // Ask permission
                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.CAMERA},REQUEST_CODE_PERMISSIONS);
            }
        }
        else {
            startCamera();
        }
    }

    private void startCamera() {
        final ListenableFuture<ProcessCameraProvider> cameraProviderFuture = ProcessCameraProvider.getInstance(this);
        cameraProviderFuture.addListener(new Runnable() {
            @Override
            public void run() {
                try {

                    ProcessCameraProvider cameraProvider = cameraProviderFuture.get();
                    bindPreview(cameraProvider);
                } catch (ExecutionException | InterruptedException e) {
                    // No errors need to be handled for this Future.
                    // This should never be reached.
                }
            }
        }, ContextCompat.getMainExecutor(this));
    }

    @SuppressLint("UnsafeOptInUsageError")
    void bindPreview(@NonNull ProcessCameraProvider cameraProvider) {
        Preview preview = new Preview.Builder().build();
        preview.setSurfaceProvider(previewView.getSurfaceProvider());

        CameraSelector cameraSelector = new CameraSelector.Builder()
                .requireLensFacing(CameraSelector.LENS_FACING_BACK)
                .build();

        ImageAnalysis imageAnalysis = new ImageAnalysis.Builder()
                // enable the following line if RGBA output is needed.
                //.setOutputImageFormat(ImageAnalysis.OUTPUT_IMAGE_FORMAT_RGBA_8888) // Has more overhead
                //.setTargetResolution(new Size(1280, 720)) // If not set, resolution of 640x480 will be selected to use in priority.
                .setBackpressureStrategy(ImageAnalysis.STRATEGY_KEEP_ONLY_LATEST)
                .build();

        ImageCapture.Builder builder = new ImageCapture.Builder();



        final ImageCapture imageCapture = builder
                .setTargetRotation(this.getWindowManager().getDefaultDisplay().getRotation()).build();

        Camera camera = cameraProvider.bindToLifecycle(this, cameraSelector, preview, imageAnalysis, imageCapture);

        /** avoid black screen? **/
        ExposureState exposureState = camera.getCameraInfo().getExposureState();
        Range<Integer> range = exposureState.getExposureCompensationRange();
        CameraControl cameraControl = camera.getCameraControl();

        /** automatic exposure compensation lock: **/
        Camera2Interop.Extender<ImageCapture> extender = new Camera2Interop.Extender<>(builder);

        //cameraControl.cancelFocusAndMetering();
        //extender.setCaptureRequestOption(CaptureRequest.CONTROL_AF_MODE, 0);  //auto focus
        //extender.setCaptureRequestOption(CaptureRequest.CONTROL_AE_MODE, 0);  //auto exposure
        //extender.setCaptureRequestOption(CaptureRequest.CONTROL_AWB_MODE, 0);  //auto white balance

        //extender.setCaptureRequestOption(CaptureRequest.BLACK_LEVEL_LOCK, true);
        //extender.setCaptureRequestOption(CaptureRequest.CONTROL_AE_LOCK, true);
        //extender.setCaptureRequestOption(CaptureRequest.CONTROL_AWB_LOCK, true);

        //extender.setCaptureRequestOption(CaptureRequest.CONTROL_AE_ANTIBANDING_MODE, 0);
        //extender.setCaptureRequestOption(CaptureRequest.SHADING_MODE, 0);

        cameraControl.setExposureCompensationIndex(range.getUpper());
        //cameraControl.cancelFocusAndMetering();











        /** analyzer **/
        imageAnalysis.setAnalyzer(executor, new ImageAnalysis.Analyzer() {
            @Override
            public void analyze(@NonNull ImageProxy image) {
                if (recording){
                    /**    **/
                    cameraControl.cancelFocusAndMetering();
                    final Bitmap bitmap = toBitmap(image.getImage());// mPreviewView.getBitmap();
                    int width = image.getWidth();
                    int height = image.getHeight();
                    image.close();

                    if (bitmap != null){
                        float Hue = 0;
                        for (int col = 0; col< width; col = col+width/Pixels_per_line ){ // + width/Pixels_per_line
                            for (int row = 0; row< height; row = row+height/Pixels_per_column ){ //  + height/Pixels_per_column
                                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                                    //version 29+
                                    Hue = Hue + (bitmap.getColor(col,row).red() + bitmap.getColor(col,row).green() + bitmap.getColor(col,row).blue() ) ;
                                } else {
                                    // lower versions
                                    Hue = Hue + (Color.red(bitmap.getPixel(col,row)) + Color.green(bitmap.getPixel(col,row)) + Color.blue(bitmap.getPixel(col,row)) ) ;
                                }
                            }
                        }
                        Hue = Hue / (Pixels_per_column*Pixels_per_line*3);
                        hueValues.add(Hue);
                        hueValues.analyze();


                        //cameraControl.setExposureCompensationIndex(range.getUpper());

                        //tv1.setText("checkpoint 42");
                        //Log.d("TAG","frame at: " + bitmap);
                    }
                } else {
                    hueValues.clear();
                    //cameraControl.startFocusAndMetering();
                }
                image.close();
            }
        });
    }

    private Bitmap toBitmap(Image image) {
        Image.Plane[] planes = image.getPlanes();
        ByteBuffer yBuffer = planes[0].getBuffer();
        ByteBuffer uBuffer = planes[1].getBuffer();
        ByteBuffer vBuffer = planes[2].getBuffer();

        int ySize = yBuffer.remaining();
        int uSize = uBuffer.remaining();
        int vSize = vBuffer.remaining();

        byte[] nv21 = new byte[ySize + uSize + vSize];
        //U and V are swapped
        yBuffer.get(nv21, 0, ySize);
        vBuffer.get(nv21, ySize, vSize);
        uBuffer.get(nv21, ySize + vSize, uSize);

        YuvImage yuvImage = new YuvImage(nv21, ImageFormat.NV21, image.getWidth(), image.getHeight(), null);
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(new Rect(0, 0, yuvImage.getWidth(), yuvImage.getHeight()), 75, out);

        byte[] imageBytes = out.toByteArray();
        return BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
    }

}