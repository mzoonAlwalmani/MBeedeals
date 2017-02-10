package mbeeseals.com.mbeedeals;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by zzzzo on 1/14/2017.
 */

public interface Service {
    @FormUrlEncoded
    @POST("register.php")
    Call<responce> register(@Field("username") String first, @Field("phone") String second , @Field("email") String thired, @Field("password") String fourth, @Field("google") String last );

}
