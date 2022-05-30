package k15hkii.se114.bookstore.data.remote;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.*;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;

public interface ModelRemote {

    @GET("/api/models/user")
    Single<List<User>> getUsers();

    @GET("/api/models/user/{id}")
    Single<User> getUser(String id);

    @POST("/api/models/user/{id}")
    Single<User> saveUser(Object obj);

    @GET("/api/models/useraddress")
    Single<List<UserAddress>> getUseraddresses();

    @GET("/api/models/useraddress/{id,index}")
    Single<UserAddress> getUseraddress(String id,String index);

    @POST("/api/models/useraddress/{id}")
    Single<UserAddress> saveUseraddress(Object obj);

    @GET("/api/models/author")
    Single<List<Author>> getAuthors();

    @GET("/api/models/author/{id}")
    Single<Author> getAuthor(String id);

    @GET("/api/models/voucherprofile")
    Single<List<VoucherProfile>> getVoucherProfiles();

    @GET("/api/models/voucherprofile/{id}")
    Single<VoucherProfile> getVoucherProfile(String id);

    @GET("/api/models/bookprofile")
    Single<List<BookProfile>> getBookprofiles();

    @GET("/api/models/bookprofile/{id}")
    Single<BookProfile> getBookprofile(String id);

    @GET("/api/models/bookprofileimage")
    Single<List<BookProfileImage>> getBookprofileimages();

    @GET("/api/models/bookprofileimage/{id}")
    Single<BookProfileImage> getBookprofileimage(String id, int i);

    @GET("/api/models/transport")
    Single<List<Transport>> getTransports();

    @GET("/api/models/transport/{id}")
    Single<Transport> getTransport(String id);

    @GET("/api/models/publisher")
    Single<List<Publisher>> getPublishers();

    @GET("/api/models/publisher/{id}")
    Single<Publisher> getPublisher(String id);

    @GET("/api/models/transporter")
    Single<List<Transporter>> getTransporters();

    @GET("/api/models/transporter/{id}")
    Single<Transporter> getTransporter(String id);

    @GET("/api/models/cartitem/{userid}")
    Single<List<CartItem>> getCartitems(String userId);

    @GET("/api/models/cartitem/{userid,bookprofileid}")
    Single<CartItem> getCartitem(String userId, String bookProfileId);

    @POST("/api/models/cartitem/{id}")
    Single<CartItem> saveCartitem(Object obj);

    @DELETE("/api/models/cartitem/{id}")
    Single<CartItem> deleteCartitem(Object obj);

    @GET("/api/models/book")
    Single<List<Book>> getBooks();

    @GET("/api/models/book/{id}")
    Single<Book> getBook(String id);

    @GET("/api/models/bill")
    Single<List<Bill>> getBills();

    @GET("/api/models/bill/{id}")
    Single<Bill> getBill(String id);

    @GET("/api/models/billdetail")
    Single<List<BillDetail>> getBilldetails(String billId);

    @GET("/api/models/billdetail/{id, boolId}")
    Single<BillDetail> getBilldetail(String id, String bookId);

    @GET("/api/models/lend")
    Single<List<Lend>> getLends();

    @GET("/api/models/lend/{id}")
    Single<Lend> getLend(String id);

    @GET("/api/models/voucher")
    Single<List<Voucher>> getVouchers();

    @GET("/api/models/voucher/{id}")
    Single<Voucher> getVoucher(String id);

    @GET("/api/models/wildvoucher")
    Single<List<WildVoucher>> getWildvouchers();

    @GET("/api/models/wildvoucher/{id}")
    Single<WildVoucher> getWildvoucher(String id);


}
