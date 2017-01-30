package mbeeseals.com.mbeedeals;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by zzzzo on 1/14/2017.
 */

public interface Service {
    @GET("register.php")
    Call<responce> getResponce(@Path("responceu") String responceu , @Path("responcee") String responcee  );

    @FormUrlEncoded
    @POST("register.php")
    Call<user> register(@Field("username") String first, @Field("phone") String second , @Field("email") String thired, @Field("password") String fourth, @Field("google") String last );

}
