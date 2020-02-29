package vanskarner.android.retrofitstructure.api_service.configuration;

import android.os.Build;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.CipherSuite;
import okhttp3.ConnectionSpec;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ConfigRetrofit {
    private static int connectTimeoutSeconds = Configuration.connectTimeoutSeconds;
    private static int readTimeoutSeconds = Configuration.readTimeoutSeconds;
    private static boolean enableLog = Configuration.enableLog;

    private static void compatibilityAndroid4(OkHttpClient.Builder httpClient) {
        /* Compatibility with versions 4.1 to 4.4 due to error [SSLProtocolException: SSL handshake aborted]  */
        try{
        if (android.os.Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN && android.os.Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
            List<CipherSuite> cipherSuites = ConnectionSpec.MODERN_TLS.cipherSuites();
            if (cipherSuites != null && !cipherSuites.contains(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA)) {
                cipherSuites = new ArrayList(cipherSuites);
                cipherSuites.add(CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA);
                ConnectionSpec spec = new ConnectionSpec.Builder(ConnectionSpec.MODERN_TLS)
                        .cipherSuites(cipherSuites.toArray(new CipherSuite[0]))
                        .build();
                httpClient.connectionSpecs(Collections.singletonList(spec));
            }
        }
        }catch (Exception ignored){

        }
    }

    private static OkHttpClient createOkHttpClient() {
        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder().connectTimeout(connectTimeoutSeconds, TimeUnit.SECONDS).readTimeout(readTimeoutSeconds, TimeUnit.SECONDS);
        compatibilityAndroid4(httpClient);
        if (enableLog) {
            httpClient.addInterceptor(logging);
        }
        return httpClient.build();
    }

    public static <S> S createService(Class<S> serviceClass, String BASE_URL) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build();
        return retrofit.create(serviceClass);
    }
}
