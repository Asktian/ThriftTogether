package com.pro516.thrifttogether.ui.network;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.pro516.thrifttogether.entity.ResponseMessageEntity;
import com.pro516.thrifttogether.entity.mall.CouponDetailsVO;
import com.pro516.thrifttogether.entity.mall.SimpleCouponVO;
import com.pro516.thrifttogether.entity.mine.CollectedProductVO;
import com.pro516.thrifttogether.entity.mine.LookingAroundShopVO;
import com.pro516.thrifttogether.entity.mine.OrderBean;
import com.pro516.thrifttogether.entity.mine.OrderDetailsVO;
import com.pro516.thrifttogether.entity.mine.ReservationBean;
import com.pro516.thrifttogether.entity.mine.ShopBean;
import com.pro516.thrifttogether.entity.mine.VoucherPackageBean;
import com.pro516.thrifttogether.ui.buy.entity.VO.CreatedOrderVO;
import com.pro516.thrifttogether.ui.buy.entity.VO.ProductDetailsVO;
import com.pro516.thrifttogether.ui.discover.bean.DiscoverShopVO;
import com.pro516.thrifttogether.ui.home.entity.VO.ShopDetailsVO;
import com.pro516.thrifttogether.ui.home.entity.VO.SimpleReviewVO;

import com.pro516.thrifttogether.entity.mine.User;
import com.pro516.thrifttogether.entity.mine.UserCoupon;
import com.pro516.thrifttogether.ui.mine.reservation.vo.SimpleReservationVO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by hncboy on 2019-05-07.
 */
public class JsonParser {

    private static final Gson mGson = new GsonBuilder().registerTypeAdapter(Date.class, new JsonDeserializer<Date>() {

        @Override
        public Date deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
            return new Date(json.getAsJsonPrimitive().getAsLong());
        }
    }).setDateFormat("yyyy-MM-dd HH:mm:ss").create();

    public static ArrayList<String> Search(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<String>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<String>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }

    public static ArrayList<SimpleCouponVO> VoucherPackage(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<SimpleCouponVO>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<SimpleCouponVO>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }

    public static CouponDetailsVO VoucherPackageDetails(String json){
        Type token=new TypeToken<ResponseMessageEntity<CouponDetailsVO>>(){
        }.getType();
        ResponseMessageEntity<CouponDetailsVO> entity=mGson.fromJson(json,token);
        if (entity.getCode()==200){
            return entity.getData();
        }else{
            return new CouponDetailsVO();
        }
    }

    public static ArrayList<UserCoupon> UserVoucherPackageLists(String json){
        Type token=new TypeToken<ResponseMessageEntity<ArrayList<UserCoupon>>>(){
        }.getType();
        ResponseMessageEntity<ArrayList<UserCoupon>> entity=mGson.fromJson(json,token);
        if (entity.getCode()==200){
            return entity.getData();
        }else{
            return new ArrayList<>();
        }
    }

    public static ArrayList<ShopBean> collectionShopList(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<ShopBean>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<ShopBean>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }

    public static ArrayList<CollectedProductVO> collectionProductList(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<CollectedProductVO>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<CollectedProductVO>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }

    public static ArrayList<ShopBean> shopList(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<ShopBean>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<ShopBean>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }

    public static ArrayList<OrderBean> Orders(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<OrderBean>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<OrderBean>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }

    public static ArrayList<DiscoverShopVO> surroundingShop(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<DiscoverShopVO>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<DiscoverShopVO>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }

    public static OrderDetailsVO OrdersDetails(String json) {
        Type token = new TypeToken<ResponseMessageEntity<OrderDetailsVO>>() {
        }.getType();
        ResponseMessageEntity<OrderDetailsVO> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new OrderDetailsVO();
        }
    }

    public static boolean updateOrders(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<OrderBean>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<OrderBean>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean login(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<OrderBean>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<OrderBean>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return true;
        } else {
            return false;
        }
    }

    public static ShopDetailsVO shopDetail(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ShopDetailsVO>>() {
        }.getType();
        ResponseMessageEntity<ShopDetailsVO> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ShopDetailsVO();
        }
    }

    public static boolean starStore(String json) {
        Type token = new TypeToken<ResponseMessageEntity<Object>>() {
        }.getType();
        ResponseMessageEntity<Object> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean cancelStarStore(String json) {
        Type token = new TypeToken<ResponseMessageEntity<Object>>() {
        }.getType();
        ResponseMessageEntity<Object> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean newReservation(String json) {
        Type token = new TypeToken<ResponseMessageEntity<Object>>() {
        }.getType();
        ResponseMessageEntity<Object> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return true;
        } else {
            return false;
        }
    }
    public static ArrayList<SimpleReviewVO> storeReview(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<SimpleReviewVO>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<SimpleReviewVO>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }
    public static User getUserInfo(String json) {
        Type token = new TypeToken<ResponseMessageEntity<User>>() {
        }.getType();
        ResponseMessageEntity<User> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new User();
        }
    }

    public static ArrayList<LookingAroundShopVO> lookingAroundShopVO(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<LookingAroundShopVO>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<LookingAroundShopVO>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }
    public static String getNewOrderId(String json) {
        Type token = new TypeToken<ResponseMessageEntity<String>>() {
        }.getType();
        ResponseMessageEntity<String> entity = mGson.fromJson(json, token);
        System.out.println("---------------------------->getNewOrderId"+entity.getCode());
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return "";
        }
    }

    public static ArrayList<ProductDetailsVO> storeProductDetails(String json){
        Type token=new TypeToken<ResponseMessageEntity<ArrayList<ProductDetailsVO>>>(){
        }.getType();
        ResponseMessageEntity<ArrayList<ProductDetailsVO>> entity=mGson.fromJson(json,token);
        if (entity.getCode()==200){
            return entity.getData();
        }else{
            return new ArrayList<>();
        }
    }

    public static ArrayList<SimpleReservationVO> getUserAllReservation(String json) {
        Type token = new TypeToken<ResponseMessageEntity<ArrayList<SimpleReservationVO>>>() {
        }.getType();
        ResponseMessageEntity<ArrayList<SimpleReservationVO>> entity = mGson.fromJson(json, token);
        if (entity.getCode() == 200) {
            return entity.getData();
        } else {
            return new ArrayList<>();
        }
    }
}
