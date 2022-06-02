package k15hkii.se114.bookstore.data.remote;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.*;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;
import java.util.UUID;

public interface ModelRemote {

    @GET("/api/model/user")
    Single<List<User>> getUsers();

    @GET("api/mode/user/self")
    Single<User> getSelfUser();

    @GET("/api/model/user/{id}")
    Single<User> getUser(String id);

    @POST("/api/model/user/{id}")
    Single<User> saveUser(Object obj);

    @GET("/api/model/useraddress")
    Single<List<UserAddress>> getUseraddresses();

    @GET("/api/model/useraddress/{id}")
    Single<UserAddress> getUseraddress(String id, String index);//TODO:

    @POST("/api/model/useraddress/{id}")
    Single<UserAddress> saveUseraddress(Object obj);

    @GET("/api/model/author")
    Single<List<Author>> getAuthors();

    @GET("/api/model/author/{id}")
    Single<Author> getAuthor(String id);

    @GET("/api/model/voucherprofile")
    Single<List<VoucherProfile>> getVoucherProfiles();

    @GET("/api/model/voucherprofile/{id}")
    Single<VoucherProfile> getVoucherProfile(String id);

    //Todo: get
    Single<List<Image>> getBookImages();

    //Todo: get
    Single<Image> getBookImage(String id, int i);

    @GET("/api/model/transport")
    Single<List<Transport>> getTransports();

    @GET("/api/model/transport/{id}")
    Single<Transport> getTransport(String id);

    @GET("/api/model/publisher")
    Single<List<Publisher>> getPublishers();

    @GET("/api/model/publisher/{id}")
    Single<Publisher> getPublisher(String id);

    @GET("/api/model/transporter")
    Single<List<Transporter>> getTransporters();

    @GET("/api/model/transporter/{id}")
    Single<Transporter> getTransporter(String id);

    @GET("/api/model/cartitem/{userid}")
    Single<List<CartItem>> getCartitems(String userId);

    @GET("/api/model/cartitem/{userid,bookprofileid}")
    Single<CartItem> getCartitem(UUID userId, UUID bookProfileId);

    @POST("/api/model/cartitem/{id}")
    Single<CartItem> saveCartitem(Object obj);

    @DELETE("/api/model/cartitem/{id}")
    Single<CartItem> deleteCartitem(Object obj);

    @GET("/api/book")
    Single<List<Book>> getBooks();

    @GET("/api/book/{id}")
    Single<Book> getBook(UUID id);

    @GET("/api/model/bill_details")
    Single<List<BillDetail>> getBillDetails(int billId);

    Single<List<Bill>> getBills();

    @GET("/api/model/bill/{id}")
    Single<Bill> getBill(String id);


    @GET("/api/model/lend")
    Single<List<Lend>> getLends();

    @GET("/api/model/lend/{id}")
    Single<Lend> getLend(String id);

    @GET("/api/model/voucher")
    Single<List<Voucher>> getVouchers();

    @GET("/api/model/voucher/{id}")
    Single<Voucher> getVoucher(String id);

    @GET("/api/model/wildvoucher")
    Single<List<WildVoucher>> getWildvouchers();

    @GET("/api/model/wildvoucher/{id}")
    Single<WildVoucher> getWildvoucher(String id);


}
