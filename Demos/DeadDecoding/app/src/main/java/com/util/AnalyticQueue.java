package com.util;

import android.util.Log;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class AnalyticQueue extends LinkedList<Float> {

    private int limit;
    private boolean isLimited = false;

    public AnalyticQueue(int limit) {

        this.limit = limit;
        this.isLimited = true;
    }

    public void analysefromstring() {
        double[] kort = {0,1,1,1,5,5,5,8,8,9,10};
        double[] sos = {0.8872, 0.9896, 1.1173333, 1.2712, 1.4712, 1.6941333, 1.926, 2.1498666, 2.4022667, 2.648, 2.8424, 3.0393333, 3.2333333, 3.3058667, 3.3354666, 3.3344, 3.3092, 3.2266667, 3.1554666, 3.1058667, 3.0992, 3.1593332, 3.2489333, 3.3398666, 3.4056, 3.4388, 3.4806666, 3.4889333, 3.4532, 3.4736, 3.4992, 3.5050666, 3.5482666, 3.5953333, 3.6141334, 3.6318667, 3.6334667, 3.5992, 3.5872, 3.558, 3.5430667, 3.5346668, 3.5578666, 3.5597334, 3.5546668, 3.5622666, 3.5670667, 3.5728, 3.5724, 3.5910666, 3.5969334, 3.5665333, 3.5757334, 3.5953333, 5.023733, 46.0364, 78.2148, 80.1072, 80.2864, 79.6316, 78.6472, 77.7884, 76.9804, 76.2208, 75.47747, 74.73773, 74.01054, 73.51573, 72.647736, 57.296665, 20.6068, 14.848933, 11.960667, 11.2172, 10.042533, 9.364, 9.0712, 8.8948, 8.731733, 8.4528, 7.5858665, 6.0494666, 5.2714667, 4.8, 4.4650664, 4.5014668, 17.498, 65.438934, 75.36093, 75.552536, 75.56333, 75.2036, 74.69213, 74.23213, 73.764, 73.3444, 72.931335, 72.46827, 71.9188, 57.491066, 12.814266, 0.5308, 0.021066668, 0.0014666667, 4.0E-4, 0.0045333332, 0.045466665, 0.25093332, 0.6376, 1.1265334, 1.5346667, 1.9274666, 2.3116, 2.6881332, 3.0085332, 3.2334666, 3.4558666, 3.6630666, 3.8290668, 5.2152, 40.470665, 77.01133, 79.82093, 79.38174, 78.57, 77.944534, 77.13347, 76.425064, 75.710266, 74.75947, 73.88827, 73.3644, 72.476135, 67.569336, 21.4776, 1.8252, 0.0030666667, 2.6666667E-4, 1.3333333E-4, 0.0, 0.0052, 0.1112, 0.3728, 0.8229333, 1.2950667, 1.7138667, 2.0690668, 2.2982666, 2.5018666, 2.7089334, 2.8353333, 2.8612, 2.8752, 2.8768, 2.9052, 2.8673334, 2.8717334, 2.9142666, 2.9478667, 2.9317334, 2.9212, 2.986, 3.1476, 6.5086665, 49.583866, 78.51693, 80.43933, 80.63907, 79.73, 78.536934, 77.10733, 76.659065, 76.0084, 75.35907, 74.54947, 74.0064, 73.430534, 72.71907, 72.1696, 71.770935, 71.36266, 71.2232, 71.08746, 71.012, 70.9012, 70.666, 68.770935, 30.8584, 1.1882666, 8.0E-4, 4.0E-4, 0.0, 0.0, 2.6666667E-4, 0.0018666667, 0.055333335, 0.2512, 0.5664, 0.9292, 1.2504, 1.7542666, 32.508133, 75.30334, 79.14733, 79.63174, 79.6208, 78.95347, 78.04546, 77.196266, 76.16, 75.1536, 74.77693, 74.13467, 73.5192, 72.92107, 72.45907, 71.996, 71.59347, 71.39453, 70.93, 70.491066, 67.51746, 19.412666, 0.007333333, 0.0, 0.0, 0.0, 0.0, 0.0014666667, 0.0516, 0.26546666, 0.50706667, 0.8896, 1.2622666, 1.6230667, 1.8033333, 1.9434667, 2.1201334, 5.4497333, 47.3576, 77.944, 80.177734, 80.11467, 79.77067, 78.6396, 77.76027, 76.77547, 75.91893, 75.25, 74.557335, 73.9204, 73.47387, 72.9108, 72.3684, 71.914665, 71.5904, 71.225464, 68.42827, 30.7896, 2.6422668, 0.105466664, 0.0041333335, 9.3333336E-4, 9.3333336E-4, 0.0112, 0.17866667, 0.46413332, 0.8536, 1.3452, 1.8684, 2.2796, 2.5070667, 2.7172, 2.8150666, 2.9436, 2.9690666, 2.9750667, 3.0016, 3.0098667, 2.9549334, 2.8925333, 2.8478668, 2.8069334, 2.6608, 2.6952, 2.7205334, 2.7373333, 2.7181334, 3.0048, 15.572133, 61.306934, 76.704, 77.983734, 79.38827, 79.31813, 78.9564, 78.15733, 77.22187, 76.44933, 75.91053, 74.93467, 74.2716, 73.602936, 73.0672, 72.31613, 71.80493, 66.78146, 22.8508, 3.1581333, 0.28266665, 0.09, 0.022266667, 0.049733333, 0.18426667, 0.44106665, 0.8312, 1.4265333, 1.9490666, 2.4774666, 3.0384, 3.7573333, 13.198267, 60.284668, 78.83107, 80.1864, 80.2512, 79.69693, 78.60706, 76.9896, 76.35133, 75.5376, 75.04293, 74.287865, 73.7404, 73.08507, 72.16013, 69.89187, 51.719868, 7.5842667, 0.54733336, 0.30626667, 0.18706666, 0.1872, 0.35066667, 0.7248, 1.2356, 1.8177333, 2.4202666, 3.0322666, 3.4101334, 3.7398667, 7.0206666, 41.861065, 75.6008, 80.28907, 80.344, 79.98707, 79.23987, 78.169334, 76.852135, 75.54733, 74.322, 73.67347, 73.248, 72.698, 71.5832, 50.481335, 5.0866666, 0.022266667, 0.0010666667, 0.0, 1.3333333E-4, 0.004, 0.07693333, 0.2828, 0.65853333, 1.0198667, 1.4696, 1.8582667, 2.2042665, 2.4481332, 2.5926666, 2.8337333, 2.8357334, 2.8394666, 2.8805332, 2.9136, 2.8990667, 2.8504, 2.8732, 2.934, 2.7825334, 2.6637332, 2.6154666, 2.5641334, 2.5277333, 2.5022666, 2.5749333, 2.6782668, 2.7577333, 2.7549334, 2.7928, 2.8429334, 2.852, 2.8462667, 2.8825333, 2.9076, 2.908, 2.9198666, 2.9225333, 2.996, 2.9693334, 2.8214667, 2.8108, 2.8014667, 2.7354667, 2.7252, 2.6613333, 2.6821334, 2.678, 2.8453333, 2.8588, 2.9029334, 2.9161334, 2.9256, 2.9350667, 2.9284, 2.8130667, 2.7817333, 2.7265334, 2.7516, 2.7265334, 2.7008, 2.7038667, 2.7288, 2.6794667, 2.6916, 2.7044};
        double[] milanVid = {26.84, 26.627466, 26.616133, 26.7472, 26.717466, 26.639734, 26.709333, 26.6608, 26.585466, 26.559334, 26.473734, 26.539066, 26.5656, 26.601866, 26.720667, 26.6652, 26.619867, 26.7248, 26.657867, 26.572, 26.652533, 26.692, 26.7092, 26.681734, 26.672934, 26.579334, 26.623734, 26.641333, 26.640266, 26.6612, 26.5976, 26.652666, 26.6816, 26.621067, 26.747066, 26.7412, 26.7792, 26.9064, 26.859333, 26.6316, 26.637867, 26.6848, 26.676134, 26.710667, 26.7696, 26.8828, 26.9736, 27.045334, 27.228266, 27.147333, 27.058268, 27.098, 27.161066, 27.206266, 27.273867, 27.294134, 27.3612, 27.400667, 27.350267, 27.368933, 27.294, 27.322533, 27.304266, 27.235466, 40.0548, 48.522266, 48.5588, 48.83853, 49.3736, 50.56893, 49.7832, 30.522533, 30.616667, 30.864933, 31.1828, 31.369333, 31.2064, 34.790268, 51.623867, 52.576935, 52.984932, 53.649868, 55.0692, 56.1728, 57.5888, 58.365334, 58.754, 59.139866, 59.890266, 60.2708, 60.438267, 60.6548, 61.0404, 61.341465, 61.62747, 61.7824, 61.862267, 62.087734, 62.271732, 62.669334, 62.808266, 63.0896, 58.65027, 40.218666, 40.3312, 40.346134, 39.414, 39.145332, 38.634533, 57.2268, 57.2936, 57.4176, 57.36627, 57.381733, 58.258533, 58.550133, 58.827465, 59.3056, 59.753735, 60.536533, 60.781067, 61.081734, 61.636665, 61.859734, 62.081867, 62.302933, 62.416134, 62.756668, 62.953335, 63.054535, 63.073868, 63.1036, 63.202133, 63.16453, 40.45627, 40.447735, 40.498, 40.600666, 40.378933, 39.55187, 46.530533, 58.151333, 58.2952, 58.3992, 58.2984, 58.6624, 58.985065, 59.2436, 59.474667, 60.056, 60.385735, 60.609734, 60.858265, 61.220665, 61.854, 62.09, 62.273335, 62.446667, 62.784534, 62.948532, 63.097733, 63.101734, 63.4576, 63.412666, 63.4784, 54.552666, 40.305866, 40.294132, 40.3432, 40.005733, 39.866932, 39.768665, 39.3276, 38.91173, 37.8488, 37.4948, 37.1408, 36.8588, 36.570534, 35.880535, 35.8216, 35.603867, 35.6452, 35.356667, 35.225735, 35.178135, 35.109066, 35.062534, 35.149734, 35.145866, 35.1904, 35.221066, 35.19253, 35.199867, 35.144665, 35.045334, 35.075733, 46.264, 55.7008, 55.8708, 56.0008, 56.5236, 57.225735, 56.916668, 38.334667, 38.378265, 38.426266, 38.539066, 38.62253, 38.4576, 38.227066, 37.9944, 37.5132, 37.31333, 36.871468, 36.8524, 35.922268, 35.724934, 35.634266, 35.09973, 35.247467, 35.2052, 35.164, 35.306667, 35.3012, 35.144, 35.204, 35.2032, 35.2008, 35.168934, 35.178932, 35.197334, 35.172535, 35.15307, 39.798134, 55.8188, 55.82147, 55.83547, 55.989735, 56.781067, 57.101067, 43.458668, 38.152134, 38.2376, 38.5768, 38.671467, 38.68667, 38.4644, 54.405735, 57.863335, 58.021866, 58.048668, 58.212532, 58.475468, 59.142, 59.4328, 59.7852, 60.225067, 60.595333, 61.098267, 61.51853, 61.74267, 62.0744, 62.363335, 62.56307, 62.772934, 62.832268, 63.00733, 62.855465, 63.0912, 63.094, 63.065067, 63.14213, 39.9764, 39.9864, 39.97, 39.9672, 39.6916, 38.56867, 56.675068, 57.8184, 57.9324, 57.992268, 58.0076, 58.3188, 50.770935, 38.2704, 38.314934, 38.372, 38.378, 38.2836, 38.156265, 37.924267, 36.8688, 36.32453, 36.187733, 35.967068, 35.649868, 34.8232, 34.6556, 34.3556, 34.39773, 34.256, 33.06053, 33.22027, 33.14, 33.106934, 33.253334, 33.212265, 33.10227, 33.029335, 32.831333, 32.65333, 32.018, 31.7028, 31.4644, 31.3276, 42.715733, 52.16987, 52.165066, 52.241467, 52.244934, 52.560665, 53.6476, 54.033066, 54.459732, 55.060932, 55.505333, 56.086266, 56.428135, 56.5396, 56.678, 56.761734, 56.70933, 56.876, 57.060665, 57.172134, 57.115467, 57.076, 57.145466, 57.379467, 57.390266, 45.65027, 33.576134, 33.740135, 33.9292, 33.841465, 33.296135, 46.062, 52.3216, 52.4768, 52.573868, 52.688934, 53.432667, 53.70627, 54.0064, 54.3948, 54.978, 55.610134, 55.975468, 56.243065, 56.555332, 56.850266, 57.518, 57.768135, 57.9272, 58.028267, 58.047466, 58.144665, 58.3488, 58.471333, 58.4712, 58.4808, 42.978535, 34.944935, 34.955067, 35.008266, 34.894535, 33.95093, 33.4816, 48.11067, 52.221466, 52.41453, 52.4812, 52.7596, 53.09693, 53.4444, 53.813732, 54.41707, 54.955734, 55.162266, 55.50733, 56.011333, 56.592133, 56.755066, 56.8896, 57.1644, 57.361332, 57.755466, 57.948666, 58.009068, 58.007065, 58.277332, 58.298534, 58.318535, 41.144268, 34.547867, 34.5864, 34.6552, 34.4148, 34.089333, 33.1672, 32.716934, 31.8116, 31.377068, 31.278267, 30.9176, 30.4884, 30.020533, 29.599867, 29.5488, 29.4912, 29.462933, 28.9868, 29.056, 28.916933, 28.6744, 28.7204, 28.593067, 28.646267, 28.7672, 28.8992, 28.9732, 28.9708, 28.996, 28.940134, 29.01, 47.2684, 50.170265, 50.224667, 50.354668, 50.889465, 51.476665, 52.9712, 53.67573, 54.016, 54.2476, 54.8272, 55.512665, 55.654133, 56.048134, 56.455334, 56.856934, 57.051468, 57.426132, 57.5544, 57.805332, 57.954132, 58.2148, 58.29907, 58.306667, 58.316, 38.528534, 34.693333, 34.8164, 34.807335, 34.464268, 34.208668, 51.393734, 52.679066, 52.749733, 52.847065, 52.821068, 53.422535, 53.654533, 53.9948, 54.328533, 54.6384, 55.237732, 55.628265, 55.8332, 56.078133, 56.628532, 56.843067, 57.172134, 57.491467, 57.590668, 57.804, 58.05493, 58.0148, 58.4244, 58.414135, 58.248, 35.381065, 34.712666, 34.795334, 34.8528, 34.722935, 33.69, 33.338135, 32.7984, 32.5796, 31.921467, 31.168133, 30.855467, 30.675467, 30.574667, 30.2292, 29.553066, 29.3164, 29.314533, 29.069733, 28.955334, 29.000267, 28.7028, 28.7744, 28.704268, 28.764534, 28.899866, 29.0704, 29.034533, 28.9732, 28.9856, 28.982267, 29.424667, 49.511734, 50.118, 50.185066, 50.249065, 50.971733, 51.47027, 43.420933, 32.53227, 32.636135, 32.6892, 32.776, 32.786667, 32.6524, 31.793867, 31.527866, 31.343334, 31.202133, 30.826, 30.1676, 30.1372, 30.053734, 29.986134, 29.736933, 28.631332, 28.671734, 28.4476, 28.445467, 28.5268, 28.828667, 28.892933, 28.979067, 28.871334, 28.8352, 28.7552, 28.758533, 28.787867, 28.798532, 28.849867, 28.727467, 28.7912, 28.818933, 28.839733, 28.7844, 28.789467, 28.805067, 28.853333, 28.857733, 28.747334, 28.769867, 28.827734, 28.831333, 28.856533, 28.860933, 28.727867, 28.692, 28.655067, 28.686, 28.6588, 28.696133, 28.6456, 28.6224, 28.678934, 28.639866, 28.703333, 28.693867, 28.761868, 28.7408, 28.715866, 28.760134, 28.648134, 28.652666, 28.621334, 28.476667, 28.150267, 27.957466, 27.7676, 27.730667, 27.602934, 27.101734, 27.098133, 27.212534, 27.223734, 27.1944, 27.1208, 27.17, 27.174534, 27.2016, 27.1368, 48.535465, 48.5788, 48.592667, 48.793335, 49.250134, 49.87253, 30.3368, 30.407467, 30.481066, 30.608932, 30.678934, 30.564133, 30.186132, 29.821466, 29.5572, 28.971733, 28.950266, 28.9124, 28.7356, 28.477467, 28.364, 28.3596, 28.1612, 27.7208, 27.815332, 27.784134, 27.8544, 27.827467, 27.914133, 27.8764, 27.819866, 27.781467, 27.818933, 27.816668, 27.842266, 27.9448, 28.067734, 32.704266, 49.073334, 49.109734, 49.2776, 49.626534, 50.407333, 50.7412, 51.383465, 52.1404, 52.8172, 53.16733, 53.466667, 53.983734, 54.646534, 54.768265, 54.9764, 55.208668, 55.3804, 55.630535, 55.99267, 56.081066, 56.142265, 56.217865, 56.3872, 56.491066, 52.332134, 33.1492, 33.1544, 33.200134, 32.746933, 32.3864, 32.0068, 37.173866, 51.0644, 51.301735, 51.356133, 50.973732, 51.2096, 34.051334, 30.979467, 31.081867, 31.1556, 31.155466, 30.686, 30.667334, 30.4236, 29.713467, 29.242533, 28.572, 28.409067, 28.070932, 27.874666, 27.738132, 27.628532, 27.517866, 27.3392, 27.343334, 27.3312, 27.125467, 26.965866, 26.6572, 26.6712, 26.639467, 26.8044, 26.9208, 27.102, 27.039467, 27.095734, 27.044, 27.000933, 26.989067, 27.015867, 26.93, 26.897066, 26.874, 26.944267, 26.994667, 27.079733, 27.218533, 27.3092, 27.2908, 27.227066, 27.345066, 27.3008, 27.236, 27.233334, 27.283733, 27.237734, 27.168667, 27.180933, 27.167734, 27.164267, 27.1716, 27.169067, 27.137333, 27.157066, 27.1924, 27.166, 27.277466, 27.2172, 27.1148, 27.160133, 27.1, 27.1612, 27.074133, 27.081333, 27.1312, 27.114532, 27.1272, 27.274933, 27.2248, 27.187334, 27.243732, 27.1048, 27.130133, 27.1028, 27.173466, 27.140533, 27.120132, 27.291733, 46.90333, 48.7104, 48.8156, 49.0516, 49.5712, 50.328533, 50.6896, 51.399334, 52.244667, 52.435467, 53.0092, 53.733067, 54.128532, 54.509468, 55.024532, 55.518, 55.7076, 56.0012, 56.191334, 56.32707, 56.469734, 56.6988, 56.718132, 56.71493, 56.4904, 34.316, 32.706135, 32.800934, 32.625465, 32.33547, 32.000134, 31.508133, 50.6488, 57.957867, 68.05627, 68.09866, 68.610535, 69.5016, 57.286667, 54.382935, 55.135468, 71.54494, 74.24173, 74.43387, 74.569336, 74.6644, 74.72747, 74.925865, 75.2164, 75.61494, 76.09267, 76.484535, 76.730934, 76.7284, 76.7716, 76.92426, 75.978264, 56.2388, 56.0492, 56.079067, 56.077866, 55.70627, 55.5664, 55.06587, 54.668667, 54.499866, 54.2468, 53.665333, 53.327465, 53.206932, 52.9708, 52.870667, 52.6652, 52.293865, 52.1188, 52.044132, 51.922134, 51.882668, 51.748665, 51.800533, 45.412533, 29.551332, 29.623867, 29.620533, 29.047066, 28.676134, 28.406933, 27.844933, 46.965065, 47.028133, 47.2016, 47.320534, 53.6148, 65.5932, 58.0904, 48.174, 48.2448, 48.428135, 49.083065, 49.363335, 49.401066, 52.97, 70.08186, 70.147736, 70.3148, 70.68867, 70.8964, 71.25774, 52.235466, 52.262535, 52.375465, 52.4852, 52.585068, 52.435867, 52.2604, 52.179867, 51.7956, 51.652668, 51.331467, 51.088135, 50.794132, 50.61347, 50.4768, 50.283867, 50.114132, 50.106, 49.9696, 49.8676, 49.778133, 49.651867, 49.549866, 49.547333, 49.5612, 49.5632, 47.606133, 47.638, 47.640133, 47.5176, 47.36, 49.998535, 66.9908, 67.02627, 67.12907, 67.4212, 67.6524, 67.86013, 63.162933, 49.1064, 49.2164, 49.374, 49.5392, 49.499866, 49.4016, 67.65947, 68.57107, 68.54467, 68.634, 68.7896, 69.01573, 69.19493, 69.4964, 69.9304, 70.32373, 70.7324, 71.016136, 71.358, 71.824, 72.183464, 72.18787, 72.2676, 72.234535, 72.444534, 72.3272, 72.41613, 72.538, 72.476, 72.49693, 72.5, 59.436, 50.437332, 50.479866, 50.558132, 50.580666, 50.042, 49.845867, 62.551067, 68.67613, 68.927864, 69.13707, 69.046936, 69.15293, 69.52586, 49.692, 49.68693, 49.776, 49.7772, 49.723465, 49.4572, 68.044, 68.542534, 68.8412, 68.816, 68.79587, 68.987335, 56.641468, 49.3604, 49.484932, 49.5788, 49.685467, 49.740265, 49.45373, 49.278934, 48.6296, 48.339466, 48.298, 48.118668, 47.604, 47.0932, 47.0992, 47.342667, 47.223732, 47.0404, 46.730534, 46.697468, 46.589733, 46.444668, 46.478268, 46.326134, 46.396534, 46.265068, 46.1292, 46.122932, 46.147068, 46.155468, 46.258934, 46.226532, 46.1952, 46.182533, 46.213333, 46.3084, 46.336666, 46.358532, 46.3004, 46.217068, 46.322, 46.3536, 46.316532, 46.278667, 46.250134, 46.222668, 46.29067, 46.2896, 46.350266, 46.322132, 46.3, 46.2476, 46.263332, 46.219734, 46.2364, 46.2208, 46.2148, 46.169334, 46.2236, 46.205467, 46.18413, 46.2288, 46.144665, 46.0996, 46.108932, 46.175068, 46.236, 46.220932, 46.152534, 46.111866, 46.065334, 46.1316, 46.206665, 46.198, 46.152668, 46.142532, 46.151867, 46.172535, 45.964535, 45.944534, 46.022266, 46.038666, 46.014668, 45.9468, 45.848667, 45.92853, 45.9532, 45.92267, 45.929466, 45.954, 45.8888, 45.8564, 45.8776, 45.831333, 45.79093, 45.812134, 45.7516, 45.7236, 45.758, 45.7236, 45.756668, 45.768135, 45.884132, 45.949867, 45.96, 46.000534, 46.024933, 46.023335, 45.936535, 45.9944, 46.008, 45.958668, 46.0832, 46.019333, 46.0556, 46.011868, 46.0828, 46.0832, 45.946667, 45.9364, 45.976265, 45.901333, 45.97587, 46.005066, 45.990532, 45.892666, 45.919334, 45.962666, 45.958, 45.8788, 45.911865, 45.9612, 45.900932, 45.906933, 45.916267, 45.9684, 45.940266, 45.87253, 45.935734, 45.934265, 45.8932, 45.8888, 45.831867, 45.771732, 45.792534, 45.792, 45.676, 45.63933, 45.692135, 45.688133, 45.6876, 45.572666, 45.580265, 45.6612, 45.656532, 45.648933, 45.691467, 45.7192, 45.667732, 45.640133, 45.635468, 45.5636, 45.510532, 45.362133, 45.333733, 45.36973, 45.2804, 45.151466, 44.9888, 44.966133, 44.956665, 44.899734, 44.8132, 44.409733, 44.3232, 44.280266, 44.2292, 44.1296, 44.129868, 44.04653, 44.065468, 44.07707, 43.9816, 43.8372, 43.8276, 43.877335, 43.8496, 43.894268, 43.8088, 43.858532, 43.9368, 44.03, 44.044, 44.1148, 44.182133, 44.1912, 44.318268, 44.3304, 44.340534, 44.388134, 44.445866, 44.482666, 44.3604, 44.4352, 44.41987, 44.36973, 44.41, 44.401867, 44.31307, 44.354668, 44.288265, 44.239067, 44.26853, 44.2504, 44.3392, 44.329468, 44.443466, 44.364933, 44.263332, 44.259468, 44.256535, 44.296, 44.255066, 44.1636, 44.2412, 44.2464, 44.192665, 44.2056, 44.3056, 44.499466, 64.60133, 65.7912, 65.86733, 66.044136, 66.467865, 66.6964, 67.12627, 67.69106, 68.7128, 68.91227, 69.15147, 69.40974, 69.88067, 70.6488, 70.87093, 70.950264, 71.1216, 71.30666, 71.7824, 71.76213, 71.85253, 72.0452, 72.22587, 72.2652, 72.32667, 72.3804, 72.4724, 72.5632, 72.60347, 72.65987, 72.733864, 72.78653, 72.79107, 72.791466, 72.83373, 72.9788, 72.99987, 72.92547, 72.967064, 73.05, 72.95786, 73.03146, 73.06053, 73.09026, 73.13226, 73.16493, 73.14253, 73.25494, 73.350266, 73.357735, 73.4016, 73.3708, 73.47013, 73.551735, 73.652, 73.678665, 73.81, 73.793335, 73.6996, 73.69307, 73.73027, 73.72414, 73.74533, 73.79653, 73.69413, 73.504, 73.5744, 73.3744, 73.3256, 73.21533, 73.2656, 72.87973, 72.863335, 72.7688, 72.7876, 72.84147, 72.82587, 72.86733, 72.8036, 72.79947, 72.766136, 72.72013, 72.726265, 72.73027, 72.90227, 72.874664, 72.818665, 72.78947, 72.9368, 73.0304, 72.79453, 72.869064, 72.8024, 72.8652, 72.8264, 72.86947, 72.7904, 72.82827, 72.848, 72.886, 73.00066, 73.02413, 73.02213, 73.0068, 73.097336, 73.16413, 73.2092, 73.24453, 73.188934, 73.238266, 73.2648, 73.36373, 73.349335, 73.479065, 73.656, 73.68307, 73.755066, 73.88053, 73.9272, 74.01507, 74.102, 74.11266, 74.19614, 74.3772, 74.547066, 74.55894, 74.61253, 74.74267, 74.8716, 74.8572, 74.94653, 74.9864, 75.00346, 75.065735, 75.16227, 75.2972, 75.37493, 75.430534, 75.43573, 75.54373, 75.63467, 75.594666, 75.616, 75.70427, 75.6664, 75.67627, 75.6096, 75.57893, 75.5756, 75.68933, 75.61587, 75.4536, 75.4268, 75.33373, 75.36027, 75.4484, 75.45506, 75.52133, 75.45613, 75.49147, 75.459335, 75.46907, 75.4924, 75.453735, 75.5676, 75.4604, 75.5328, 75.4232, 75.237335, 75.2096, 75.2916, 75.3004, 75.23987, 75.2076, 75.252, 75.32747, 75.37347, 75.360664, 75.31707, 75.40773, 75.39747, 75.374664, 75.33653, 75.303734, 75.33987, 75.3772, 75.32933, 75.29867, 75.39467, 75.515335, 75.420265, 75.369865, 75.4212, 75.472664, 75.453735, 75.4364, 75.42253, 75.380135, 75.32253, 75.3164, 75.37627, 75.33227, 75.3464, 75.33694, 75.28347, 75.304, 75.17827, 75.21053, 75.24374, 75.208664, 75.26147, 75.3616, 75.406, 75.29787, 75.291336, 75.270134, 75.27707, 75.32373, 75.184135, 75.27773, 75.2272, 75.19987, 75.208, 75.24133, 74.5368, 52.658535, 52.153732, 52.2076, 51.910267, 51.7968, 51.59973, 50.960133, 51.579468, 69.32867, 69.30133, 69.408, 69.444534, 69.58427, 70.0736, 70.34067, 70.69067, 71.03373, 71.4484, 71.87427, 72.136536, 72.5416, 72.8388, 73.065735, 73.33307, 73.5344, 73.7072, 73.64626, 74.01947, 74.02533, 74.01947, 74.01746, 74.07187, 74.04494, 51.1032, 51.176666, 51.1428, 51.123466, 50.839333, 50.152534, 49.9084, 49.227333, 48.832134, 48.609734, 47.625866, 47.4452, 47.383465, 47.051067, 46.8096, 46.430134, 46.281067, 46.179733, 46.1232, 46.0112, 45.9432, 45.898933, 45.843334, 45.894268, 45.801334, 45.751465, 45.6668, 45.6808, 45.7532, 45.776134, 45.8012, 50.6584, 66.7532, 66.894, 67.04587, 67.3668, 67.83107, 68.23587, 69.2452, 69.4112, 70.17053, 70.78813, 71.09814, 71.42387, 71.944, 72.62213, 72.94707, 73.152664, 73.3532, 73.57613, 73.6904, 73.78947, 73.99413, 73.57387, 74.005066, 73.920265, 73.9208, 56.4096, 50.964535, 50.97893, 50.994, 50.81, 50.641735, 49.793865, 62.544533, 69.068665, 69.216, 69.37, 69.538666, 69.87147, 50.581867, 49.860535, 49.940933, 49.946266, 49.8952, 49.452, 49.2104, 48.843735, 48.517868, 48.135334, 47.4972, 47.490932, 47.2448, 47.072666, 46.625732, 46.238667, 46.146667, 46.028133, 45.86067, 45.8504, 45.690533, 45.72027, 45.708, 45.7416, 45.6544, 45.571068, 45.5832, 45.5776, 45.58853, 45.5384, 45.546135, 45.529335, 45.53507, 45.6048, 45.488667, 45.39, 45.382267, 45.396935, 45.389866, 45.3624, 45.261066, 45.249733, 45.234, 45.166935, 45.156666, 45.204666, 45.2208, 45.238132, 45.317867, 45.339333, 45.2756, 45.273468, 45.337067};
        double[] milanVid2 = {108.8052, 108.8464, 108.8208, 108.79373, 108.87093, 108.81547, 108.75906, 108.85107, 108.833466, 108.78733, 108.86214, 108.83573, 108.7736, 108.92253, 108.8636, 108.79187, 108.94, 108.86733, 108.66787, 108.8336, 108.7532, 108.7224, 108.8924, 108.784935, 108.6868, 108.829735, 108.7108, 108.63253, 108.8872, 108.7164, 108.769066, 118.73, 154.6144, 145.29373, 146.4532, 147.29013, 147.9964, 149.1504, 148.89827, 149.22133, 149.85173, 149.91653, 150.23294, 150.69974, 150.63907, 150.70093, 150.95706, 150.88454, 150.83026, 150.9228, 150.85266, 150.66533, 150.55, 150.46094, 149.9104, 149.7672, 147.60667, 98.697334, 104.6116, 104.184135, 103.62347, 103.4436, 102.011734, 108.4896, 145.17014, 135.32106, 135.52933, 136.05814, 136.52426, 137.21106, 136.8864, 137.79333, 138.14227, 138.4624, 138.4264, 138.438, 138.72867, 138.6604, 138.6608, 138.7592, 138.74107, 138.42627, 138.23773, 138.10347, 137.6032, 137.27386, 136.9352, 136.4824, 135.156, 90.149864, 92.2328, 91.77053, 91.431465, 90.67253, 89.87894, 90.00107, 89.791466, 89.62093, 89.3292, 88.70067, 89.0196, 89.314, 89.19853, 89.61373, 89.6072, 89.779465, 90.3344, 90.3488, 90.6908, 91.24347, 91.21, 91.54733, 92.076935, 92.03107, 92.270134, 93.0144, 92.987335, 93.258934, 93.64053, 93.9348, 94.372, 138.7092, 139.10507, 138.1536, 138.84053, 139.53, 140.332, 124.9924, 102.044266, 107.0288, 106.50667, 105.87133, 105.16707, 105.01387, 141.9372, 138.72414, 137.0104, 137.798, 138.16054, 138.5012, 121.46173, 101.00173, 105.786934, 105.3144, 105.12614, 104.7052, 103.936134, 103.691864, 103.62493, 103.18307, 102.07107, 102.05334, 102.0436, 101.782936, 101.72507, 101.63454, 101.35173, 101.24547, 101.17374, 100.7572, 100.8212, 100.75906, 100.6756, 100.73293, 100.6716, 100.517334, 100.71854, 100.6232, 100.58093, 100.93667, 100.93214, 100.92893, 129.34933, 148.82947, 142.9392, 144.53906, 145.2064, 145.6132, 142.97574, 103.804535, 112.41053, 112.04173, 111.29774, 111.02347, 110.286934, 134.13213, 148.41853, 142.26146, 142.98466, 143.32294, 143.8456, 143.8272, 143.8604, 144.7936, 144.85226, 145.4336, 145.73694, 145.6868, 145.7024, 145.89746, 145.85986, 145.78787, 145.88507, 145.8308, 145.62494, 145.45947, 145.464, 145.12747, 144.83307, 144.28093, 131.21254, 92.1544, 97.86107, 97.13253, 97.05293, 96.089066, 95.844536, 108.588264, 137.9308, 129.06853, 129.8848, 130.0224, 130.314, 130.4044, 93.12334, 97.49453, 97.8188, 97.2604, 97.04947, 96.6824, 109.9764, 138.00987, 129.32814, 130.0148, 130.06987, 130.32947, 130.73894, 92.538666, 98.17747, 98.39613, 97.87773, 97.802536, 96.954666, 97.080536, 96.667336, 96.6268, 95.9656, 95.825066, 95.5492, 95.18494, 95.296, 95.15707, 95.04093, 95.14173, 95.1044, 94.917465, 95.0776, 95.0332, 95.0588, 95.3772, 95.3564, 95.50107, 95.982666, 95.9888, 96.1416, 96.64027, 96.64, 96.76147, 101.12027, 148.33147, 140.9168, 141.3108, 141.6048, 142.16093, 142.71413, 113.42187, 106.98707, 109.15933, 108.68787, 108.3704, 108.05293, 110.76507, 148.59827, 139.5616, 139.7188, 139.9656, 140.43413, 140.6224, 140.57933, 141.57373, 141.95253, 142.31853, 142.59134, 142.544, 142.64174, 143.06973, 143.05746, 143.09734, 143.10933, 142.9428, 142.56787, 142.59653, 142.528, 142.20866, 141.83347, 141.62253, 140.80693, 94.63347, 95.48413, 95.717865, 95.363335, 94.722, 94.3848, 93.9008, 93.822266, 93.4484, 93.259735, 93.08507, 92.72947, 92.54387, 92.532265, 92.3452, 92.3756, 92.48613, 92.183464, 92.37307, 92.285736, 92.2868, 92.4604, 92.5128, 92.734, 93.06493, 93.043335, 93.1164, 93.63454, 93.633865, 93.81893, 94.1724, 94.26027, 125.03146, 143.0112, 138.018, 138.8296, 139.7288, 140.13626, 140.29266, 140.51106, 140.91267, 141.18573, 141.7216, 141.73906, 141.8576, 142.18613, 142.13586, 142.10786, 142.07773, 142.02547, 141.69574, 141.5912, 141.2836, 140.65067, 140.4304, 140.23694, 139.66386, 124.52707, 88.276535, 93.6232, 93.1296, 92.7456, 92.18494, 91.88813, 108.71107, 131.60333, 124.37973, 125.454, 125.583336, 126.26186, 125.452934, 87.42934, 93.7836, 93.58027, 93.0528, 92.7388, 92.118935, 92.01, 91.5232, 91.093735, 90.757866, 90.6688, 90.249466, 90.04853, 90.077866, 90.1176, 89.8808, 90.08493, 90.0196, 89.98413, 90.14253, 90.10253, 90.1472, 90.564, 90.56813, 90.7724, 91.3628, 91.39333, 91.634, 92.27067, 92.23693, 92.55413, 93.1192, 93.12666, 93.483864, 94.1556, 94.2104, 94.5604, 95.20827, 95.17133, 95.804, 96.15853, 96.268, 96.53907, 96.96333, 97.35893, 97.38827, 97.97787, 97.94133, 98.35827, 99.03426, 99.04747, 99.4344, 100.1616, 100.2036, 100.5708, 101.3148, 101.350266, 101.734665, 102.4064, 102.42374, 102.81187, 103.38613, 103.322, 103.5156, 104.074, 104.08227, 104.24627, 104.7012, 104.71827, 104.81973, 105.09026, 105.296135, 105.5148, 105.7696, 105.7008, 105.70827, 106.01186, 105.91907, 105.9768, 106.32747, 106.29467, 108.177864, 152.05186, 144.7068, 145.38986, 146.18854, 146.72374, 147.91614, 121.0444, 110.849464, 113.8204, 113.33453, 112.40427, 111.95973, 111.47187, 111.094, 110.50533, 110.2156, 109.6264, 109.21453, 109.11787, 108.8508, 108.25774, 108.19106, 108.10347, 107.68947, 107.566666, 107.5548, 107.2108, 107.276535, 107.1828, 107.040535, 107.0052, 106.89253, 106.560936, 106.633064, 106.5596, 106.262, 106.232666, 106.736664, 148.08147, 141.56267, 141.9208, 142.90533, 143.64214, 144.66333, 144.38054, 145.4312, 145.78, 145.84067, 146.32933, 146.46106, 146.96027, 147.0296, 147.03667, 146.8908, 147.00906, 146.9384, 146.72374, 146.6856, 146.6268, 146.28346, 146.02986, 145.89427, 145.3952, 101.9124, 99.3016, 99.95734, 99.04214, 98.75387, 97.52507, 99.1588, 139.57626, 131.45387, 131.218, 132.0604, 132.5404, 132.75146, 106.318665, 96.8748, 99.7332, 99.381065, 98.9676, 98.82747, 98.21067, 98.3572, 97.9772, 97.99053, 97.34067, 97.29453};
        double[] milanVid3 = {93.40173, 93.49693, 93.4864, 93.4596, 93.506134, 93.5096, 93.42947, 93.459335, 93.4428, 93.34213, 93.35627, 93.335335, 93.142136, 93.3012, 93.268, 93.17547, 93.3988, 93.322136, 93.23293, 93.43227, 93.2848, 93.05067, 93.26186, 93.2328, 93.03333, 93.1524, 93.0764, 92.94093, 95.2056, 103.3448, 101.804665, 102.4776, 102.61013, 102.7136, 103.16827, 94.93293, 94.72974, 94.84973, 94.59693, 94.3108, 94.2992, 94.053734, 93.8252, 102.7292, 101.95627, 101.93253, 102.59026, 102.65213, 102.7212, 98.958664, 94.278534, 95.14613, 95.0068, 94.7076, 94.4788, 94.32107, 95.503334, 104.12693, 102.45, 102.475464, 102.5548, 102.73867, 102.75747, 94.22667, 94.939735, 94.76787, 94.74133, 94.71253, 94.66227, 94.44946, 100.3988, 102.801735, 101.96827, 102.52973, 102.568, 102.66413, 101.789734, 93.7872, 95.206, 94.99173, 94.66147, 94.43826, 94.3892, 94.364265, 94.09333, 93.9384, 93.79826, 93.64093, 93.6784, 93.544, 93.37, 93.478935, 93.42654, 93.2512, 93.34427, 93.3148, 93.1208, 93.1644, 93.1604, 93.0944, 93.2284, 93.174, 93.05507, 93.14747, 93.079865, 93.00933, 93.25853, 93.128265, 92.92067, 93.024536, 103.20613, 101.45893, 102.2956, 102.29867, 102.470535, 102.90573, 97.01693, 94.268265, 94.9552, 94.74506, 94.41267, 94.42986, 94.33987, 96.3672, 103.78986, 102.20707, 102.296135, 102.81253, 102.81133, 102.8324, 103.62987, 103.6276, 103.65933, 103.897064, 103.88174, 103.757065, 103.9216, 103.920135, 103.83107, 104.09347, 104.0688, 103.9248, 103.9872, 103.98507, 103.9296, 104.11253, 104.10333, 104.00853, 103.88333, 93.8868, 95.80867, 95.64267, 95.07653, 94.73707, 94.62666, 94.23987, 94.15987, 94.18027, 94.1556, 93.80147, 93.9104, 93.73013, 93.514534, 93.654, 93.64854, 93.50453, 93.585464, 93.5768, 93.34827, 93.4916, 93.48013, 93.32173, 93.3636, 93.35986, 93.28, 93.4152, 93.4012, 93.2204, 93.3352, 93.1336, 93.1024, 93.2348, 100.93453, 102.1724, 102.122665, 102.3332, 102.49067, 102.83507, 100.54307, 93.5408, 94.758934, 94.64294, 94.59547, 94.56907, 94.3392, 94.0488, 104.0332, 102.061066, 102.0948, 102.622665, 102.6724, 102.6904, 103.1456, 103.1484, 103.175735, 103.687065, 103.6672, 103.72747, 103.87373, 103.79307, 103.8044, 104.036, 104.0084, 103.84347, 103.899734, 103.90427, 103.875336, 104.08773, 104.06506, 103.98973, 104.1684, 95.041336, 95.83773, 95.60413, 95.08466, 94.874535, 94.71547, 94.28986, 96.4752, 103.89933, 102.3168, 102.46613, 103.02333, 103.11, 103.10706, 94.06506, 95.397064, 95.371735, 95.26013, 94.87946, 94.330536, 94.34067, 101.718, 102.3248, 102.490135, 102.566666, 102.54293, 102.98587, 100.541336, 93.9424, 94.85173, 94.69347, 94.5812, 94.60253, 94.47453, 94.2328, 94.20773, 94.05106, 93.86373, 93.97933, 93.90427, 93.692665, 93.78347, 93.73814, 93.540535, 93.59787, 93.63786, 93.50587, 93.59333, 93.4924, 93.172264, 93.3376, 93.275734, 93.127335, 93.313866, 93.205734, 93.05894, 93.28107, 93.14933, 93.08787, 93.20226, 96.627464, 103.0988, 102.20226, 102.35094, 102.5944, 103.0228, 102.9744, 93.32294, 95.216934, 95.018135, 94.903465, 94.878, 94.46014, 94.300934, 101.38427, 102.73587, 102.291466, 102.6864, 102.73027, 103.03067, 103.55067, 103.5208, 103.417336, 103.766, 103.756, 103.69147, 104.0388, 103.97947, 103.87773, 104.00107, 104.0072, 103.93107, 104.11266, 104.08173, 103.92667, 104.15773, 104.1424, 104.01227, 104.1664, 99.9276, 94.892, 95.8356, 95.305336, 95.1412, 95.15746, 94.94347, 94.639465, 103.117065, 102.33293, 102.1192, 102.7584, 102.79933, 102.89066, 99.45707, 94.49453, 95.475464, 95.29187, 95.05347, 94.764, 94.790535, 95.557465, 104.446, 102.628265, 102.7956, 102.90107, 103.07093, 103.1008, 94.966, 95.47453, 95.38427, 95.2504, 95.21333, 95.1396, 94.87773, 94.8308, 94.74253, 94.436, 94.46, 94.287735, 94.2256, 94.28187, 94.2752, 94.24, 94.354935, 94.32294, 94.17613, 94.19, 94.19386, 94.15933, 94.2256, 94.20973, 94.09534, 93.99907, 93.96613, 93.9188, 94.01107, 93.97093, 93.79653, 93.9268, 93.8872, 100.78373, 102.293465, 102.1112, 102.21333, 102.97933, 103.0112, 103.12867, 103.722664, 103.69666, 103.82467, 103.97773, 103.97187, 103.866135, 104.15493, 104.08667, 103.9332, 104.10467, 104.105736, 104.077065, 104.3548, 104.34, 104.26227, 104.48613, 104.34547, 104.3004, 100.299736, 95.6008, 96.32107, 95.9988, 95.50187, 95.200134, 95.29107, 95.259735, 104.3992, 102.535866, 102.68, 102.85413, 103.19933, 103.3604, 103.546135, 103.923065, 103.891335, 103.784, 104.030266, 104.0172, 103.9672, 104.1976, 104.2048, 104.10053, 104.427734, 104.400665, 104.25187, 104.51987, 104.41707, 104.2636, 104.38893, 104.37853, 104.31747, 96.4428, 96.27427, 96.3704, 95.98507, 95.388535, 95.1984, 95.055336, 95.5892, 104.41534, 102.73627, 102.78, 102.94027, 103.3768, 103.36667, 103.305336, 103.927734, 103.84627, 103.8404, 103.98133, 103.987335, 103.919334, 104.21173, 104.191864, 104.060265, 104.3132, 104.2916, 104.175735, 104.27413, 104.265335, 104.225464, 104.476, 104.47307, 104.369736, 95.2012, 96.352264, 96.1388, 95.77, 95.19867, 95.0672, 94.99707, 94.76093, 94.48, 94.66893, 94.64053, 94.42347, 94.6172, 94.2976, 94.19, 94.28827, 94.26387, 94.12347, 94.1828, 94.17253, 94.05213, 94.06467, 93.916664, 93.802536, 93.97694, 93.969864, 93.83974, 93.9416, 93.85253, 93.65667, 93.810936, 93.81333, 93.71267, 93.84413, 93.74173, 93.582535, 93.75853, 93.60133, 93.55493};
        double[] milanVid4 = {93.01133, 93.07346, 93.064, 93.0052, 93.0636, 93.06987, 92.99533, 93.076, 93.071335, 92.99053, 93.0504, 93.04, 92.978264, 93.14014, 93.12627, 93.018265, 93.255066, 93.16613, 93.08947, 93.28893, 93.173065, 93.076935, 93.163734, 94.73573, 94.2816, 94.83013, 94.777466, 94.744, 94.965065, 94.22307, 93.86373, 94.09427, 94.0348, 93.8748, 94.1316, 94.11947, 95.4484, 95.25066, 95.22, 95.04587, 95.291466, 95.3064, 94.964935, 94.0896, 94.336266, 94.12307, 94.284134, 94.18494, 93.999466, 95.28986, 95.194534, 95.04947, 95.347466, 95.35667, 95.26507, 95.367065, 94.2648, 94.41973, 94.51653, 94.26054, 94.16707, 94.19106, 95.3348, 95.13454, 95.34133, 95.268265, 95.10053, 95.32053, 95.0924, 93.95133, 94.417465, 94.30987, 94.2176, 94.316666, 94.2116, 94.04667, 94.1352, 94.12853, 93.93307, 94.0028, 93.84133, 93.66893, 93.7508, 93.7484, 93.69933, 93.79467, 93.7172, 93.526, 93.6148, 93.4008, 93.380264, 93.55147, 93.5136, 93.31133, 93.51147, 93.35, 93.1984, 93.2808, 93.28347, 93.17893, 94.1576, 94.600136, 94.324265, 94.8488, 94.83173, 94.8032, 95.15414, 93.792, 93.99187, 94.158264, 93.96173, 93.85467, 93.9228, 94.72587, 95.088264, 95.0712, 95.1404, 95.005066, 95.24427, 95.17146, 95.25107, 95.51573, 95.50253, 95.41333, 95.7576, 95.75733, 95.647064, 95.77267, 95.77053, 95.7396, 96.000534, 95.959465, 95.87573, 96.150665, 96.01093, 95.930664, 96.11587, 96.10426, 95.758, 94.728264, 94.903336, 94.59627, 94.69373, 94.64187, 94.47467, 94.5292, 94.361465, 94.15507, 94.19347, 93.98534, 93.86214, 94.00373, 93.9944, 93.857864, 93.967735, 93.8388, 93.61, 93.69386, 93.69093, 93.63693, 93.762535, 93.68266, 93.55386, 93.65694, 93.352135, 93.2504, 93.3412, 93.3364, 93.2564, 93.464134, 93.46067, 94.8836, 94.8456, 94.91547, 94.82027, 95.23213, 95.19386, 94.01387, 94.167465, 94.0752, 94.279335, 94.33, 94.31, 94.19413, 95.6544, 95.192665, 95.10613, 95.36453, 95.34413, 95.20627, 95.51867, 95.42, 95.33653, 95.680534, 95.669464, 95.552536, 95.68387, 95.6844, 95.6096, 95.92693, 95.894264, 95.82947, 96.0812, 96.07453, 95.98613, 96.2812, 96.24187, 96.1152, 96.226135, 94.602135, 94.99413, 95.05013, 94.905334, 94.6492, 94.7116, 94.55386, 95.94213, 95.71, 95.7404, 95.5368, 95.74907, 95.72773, 94.9264, 94.50533, 94.5616, 94.42067, 94.597336, 94.414536, 94.24973, 95.7884, 95.43093, 95.32547, 95.48987, 95.46453, 95.36387, 94.98227, 94.45226, 94.5472, 94.60387, 94.46827, 94.17654, 94.29187, 94.1104, 93.93933, 93.99613, 93.87106, 93.65013, 93.7688, 93.74187, 93.6076, 93.75453, 93.66227, 93.51413, 93.64107, 93.5964, 93.385735, 93.5604, 93.299736, 93.228, 93.457466, 93.3468, 93.2096, 93.3964, 93.3672, 93.2092, 93.470535, 93.38547, 94.60094, 94.74053, 94.642, 94.93227, 95.17907, 95.053734, 94.5824, 93.905464, 94.10067, 93.955734, 94.13213, 94.0616, 93.9272, 95.3696, 95.16573, 95.10453, 95.41773, 95.39587, 95.319466, 95.6312, 95.66347, 95.54387, 95.76587, 95.7612, 95.6752, 95.946, 95.90933, 95.79453, 96.15667, 96.086136, 96.04, 96.16347, 96.077736, 95.97227, 96.1964, 96.08987, 95.972664, 96.17627, 95.574265, 94.732, 94.93227, 94.74187, 94.58307, 94.683464, 94.50107, 95.4076, 95.7932, 95.64373, 95.4144, 95.6584, 95.5788, 95.36453, 94.30493, 94.5264, 94.3272, 94.467865, 94.28453, 94.10453, 95.21733, 95.37027, 95.107735, 95.2228, 95.14346, 95.19334, 95.42986, 94.1256, 94.3112, 94.4068, 94.37013, 94.175735, 94.24173, 94.08974, 93.894936, 94.06267, 93.978264, 93.7696, 93.89253, 93.8708, 93.725464, 93.72173, 93.577866, 93.28093, 93.43107, 93.4052, 93.18733, 93.4436, 93.29667, 93.161865, 93.447334, 93.3984, 93.257866, 93.4428, 93.28467, 93.18587, 93.40227, 93.316, 93.8284, 94.89893, 94.8004, 94.73133, 95.166534, 95.1268, 95.0128, 95.372665, 95.3844, 95.25107, 95.66973, 95.62853, 95.5068, 95.8624, 95.79494, 95.6456, 95.8832, 95.87707, 95.7476, 96.10387, 96.03747, 95.867065, 96.030266, 96.006134, 95.910934, 96.02026, 94.37627, 94.9864, 94.92667, 94.7352, 94.60907, 94.69614, 94.75774, 96.0224, 95.646, 95.610535, 95.484, 95.6976, 95.6948, 95.56493, 95.92547, 95.82253, 95.751465, 95.88333, 95.922, 95.75214, 95.9548, 95.95053, 95.87933, 96.10253, 96.05507, 95.91213, 96.10253, 96.079735, 95.9108, 96.209335, 96.09987, 95.97853, 94.73707, 94.93667, 94.79187, 94.85173, 94.82533, 94.663734, 94.5828, 95.99053, 95.40093, 95.6136, 95.5876, 95.4364, 95.70893, 95.695465, 95.557465, 95.9344, 95.9108, 95.771866, 95.91213, 95.90453, 95.82747, 96.085335, 96.06547, 95.917336, 96.192665, 96.146, 96.00293, 96.200264, 96.0788, 96.0604, 96.17426, 96.1772, 94.786934, 94.77987, 94.758934, 94.62213, 94.7072, 94.55853, 94.36027, 94.48307, 94.26387, 94.1836, 94.272934, 94.214, 93.957466, 94.09306, 94.08147, 93.9344, 94.0124, 93.902534, 93.70053, 93.833466, 93.75853, 93.56693, 93.8044, 93.6612, 93.51413, 93.6256, 93.53253, 93.3592, 93.4428, 93.32947, 93.13627, 93.3752, 93.23787, 93.15933, 93.44307, 93.35706, 93.19213, 93.368, 93.312, 93.111336, 93.2708, 93.253334, 93.0796, 93.33573, 93.214134, 93.078, 93.28347, 93.211334, 93.04653, 93.25547, 93.225464, 93.08, 93.3172, 93.194534, 93.0692, 93.1904, 93.097336, 93.01013 };

        for (int i = 0; i < milanVid.length; i++)
            {
                this.add((float) milanVid[i]);
            }
        //this.addAll(Arrays.asList(values));
        this.analyze();
    }

    public AnalyticQueue() {
        this.isLimited = false;
    }

    @Override
    public boolean add(Float o) {
        boolean added = super.add(o);
        while (isLimited && added && size() > limit) {
            super.remove();
        }
        return added;
    }

    public String analyze() {
        int comment = 1;
        if (this.size()<3){
            return "0";
        }
        //Infinite impulse response

        //apply IIR filter
        List<Float> filteredData = new ArrayList<>(size()-0);
        filteredData.add(0,get(0));
        for (int i = 1; i<size()-1 ; i++){
            filteredData.add(i,(this.get(i-1) + this.get(i) + this.get(i + 1)) / 3);
        }

        //Edge detection
        Float[] differences = new Float[size()-1];
        filteredData.add(size()-1,get(this.size()-1));
        float avg = 0;
        for (int i = 0; i<size()-1; i++){
            //Log.d("dif "+i, ":" + (filteredData[i] - filteredData[i+1]));
            differences[i] = filteredData.get(i) - filteredData.get(i+1);
            avg+= Math.abs(filteredData.get(i) - filteredData.get(i+1));
        }
        avg/= size()-1;

        //Edge duration
        List<Integer> edges = new ArrayList<>(size()-1);
        //detect rising and falling hue edges
        for (int i = 0; i<size()-1; i++){
            if(Math.abs(differences[i]) > avg) {
                if (differences[i] < 0) {
                    edges.add(i, 1);
                } else {
                    edges.add(i, -1);
                }
            } else {
                edges.add(i, 0);
            }
        }
        if (comment != 0){
            Log.d("size", " " + this.size());
            Log.d("hue", " " + this);
            Log.d("IIR", " " + filteredData);
            Log.d("avg", " " + avg);
            Log.d("edges ", ", " + edges);
        }
        return MorseDecoder.decode(edges);
    }

}