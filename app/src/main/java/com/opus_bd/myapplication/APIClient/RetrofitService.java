package com.opus_bd.myapplication.APIClient;


import com.opus_bd.myapplication.Model.Group.GroupPost;
import com.opus_bd.myapplication.Model.User.UserListModel;
import com.opus_bd.myapplication.Model.User.UserLoginModel;
import com.opus_bd.myapplication.Model.User.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {

    @POST("api/Auth/login")
    Call<UserModel> login(@Body UserLoginModel userLoginModel);

    @GET("api/Message/GetEmployeeInfoExceptMe/{userId}")
    Call<List<UserListModel>> GetEmployeeInfoExceptMe(@Path("userId") int userId);

    @GET("api/Message/GetGroupsForMe/{userId}")
    Call<List<UserModel>> GetGroupsForMe(@Path("userId") int userId);


    @GET("api/Message/GetMessageEmployeeInfoById/{Id}")
    Call<UserListModel> GetMessageEmployeeInfoById(@Path("Id") int Id);

    @GET("api/Message/GetAllMessageGroupMemberBygrpId/{groupId}")
    Call<List<UserModel>> GetAllMessageGroupMemberBygrpId(@Path("groupId") int groupId);

    @GET("api/Message/GetAllEmployeesNotInGroupBygrpId/{groupId}")
    Call<List<UserModel>> GetAllEmployeesNotInGroupBygrpId(@Path("groupId") int groupId);

    @GET("api/Message/GetAllMessageGroup")
    Call<List<UserModel>> GetAllMessageGroup();

    @POST("Message/MessageBox/GroupCreate")
    Call<Integer> GroupCreate(@Body GroupPost groupPost);


}