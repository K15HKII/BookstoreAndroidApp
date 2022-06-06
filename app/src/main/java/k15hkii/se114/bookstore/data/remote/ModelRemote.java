package k15hkii.se114.bookstore.data.remote;

import io.reactivex.Completable;
import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.*;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

import java.util.List;
import java.util.UUID;

public interface ModelRemote {
    //User
    @GET("/api/model/user")
    Single<List<User>> getUsers();

    @GET("api/mode/user/self")
    Single<User> getSelfUser();

    @GET("/api/model/user/{id}")
    Single<User> getUser(@Path("id") UUID id);

    //Author
    @GET("/api/author/{id}")
    Single<Author> getAuthor(@Path("id") int id);

    @POST("api/author/{id}")
    Single<Author> updateAuthor(@Path("id") int id);

    @DELETE("api/author/{id}")
    void deleteAuthor(@Path("id") int id);

    @GET("/api/author")
    Single<List<Author>> getAuthors();

    @POST("api/author")
    Single<Author> createAuthor();
    //Book
    @GET("/api/book/search")
    Single<List<Book>> getBooks();

    @GET("/api/book/info/{id}")
    Single<Book> getBook(@Path("id") UUID id);

    //Publisher
    @GET("/api/publisher/{id}")
    Single<Publisher> getPublisher(@Path("id") int id);

    @POST("api/publisher/{id}")
    Single<Publisher> updatePublisher(@Path("id") int id);

    @DELETE("api/publisher/{id}")
    void deletePublisher(@Path("id") int id);

    @GET("/api/publisher")
    Single<List<Publisher>> getPublishers();

    @POST("api/publisher")
    Single<Publisher> createPublisher();

    //Transporter
    @GET("/api/transporter/{id}")
    Single<Transporter> getTransporter(@Path("id") int id);

    @POST("api/transporter/{id}")
    Single<Transporter> updateTransporter(@Path("id") int id);

    @DELETE("api/transporter/{id}")
    void deleteTransporter(@Path("id") int id);

    @GET("/api/transporter")
    Single<List<Transporter>> getTransporters();

    @POST("api/transporter")
    Single<Transporter> createTransporter();

    //User
    //RecentBook
    @GET("/api/user/recents/{user_id}")
    Single<List<Book>> getRecentBooks(@Path("user_id") UUID user_id);

    @POST("/api/user/recent/{user_id}")
    Single<Book> createRecentBook(@Path("user_id") UUID user_id);

    //FavoriteBook
    @GET("/api/user/favourites/{user_id}")
    Single<List<Book>> getFavoriteBooks(@Path("user_id") UUID user_id);

    @POST("/api/user/favourite/{user_id}")
    Single<Book> createFavoriteBook(@Path("user_id") UUID user_id);

    @DELETE("/api/user/favourite/{user_id}")
    void deleteFavoriteBook(@Path("user_id") UUID user_id);
    //CartItem
    @GET("/api/user/carts/{user_id}")
    Single<List<CartItem>> getCarts(@Path("user_id") UUID user_id);

    @POST("/api/user/cart/{user_id}")
    Single<CartItem> createCart(@Path("user_id") UUID user_id);

    @DELETE("/api/user/cart/{user_id}")
    void deleteCart(@Path("user_id") UUID user_id);

    //Bill
    @GET("/api/bill/{id}")
    Single<Bill> getBill(@Path("id") int id);

    @GET("/api/user/bills/{user_id}")
    Single<List<Bill>> getBills(@Path("user_id") UUID user_id);

    @POST("/api/user/bill/{user_id}")
    Single<Bill> createBill(@Path("user_id") UUID user_id);

    @DELETE("/api/user/bill/{user_id}")
    void deleteBill(@Path("user_id") UUID user_id);

    //Address
    @GET("/api/user/addresses/{user_id}")
    Single<List<UserAddress>> getAddresses(@Path("user_id") UUID user_id);

    @POST("/api/user/address/{user_id}")
    Single<UserAddress> createAddress(@Path("user_id") UUID user_id);

    @DELETE("/api/user/address/{user_id}")
    void deleteAddress(@Path("user_id") UUID user_id);

    //Bank
    @GET("/api/user/banks/{user_id}")
    Single<List<UserBank>> getBanks(@Path("user_id") UUID user_id);

    @POST("/api/user/bank/{user_id}")
    Single<UserBank> createBank(@Path("user_id") UUID user_id);

    @DELETE("/api/user/bank/{user_id}")
    void deleteBank(@Path("user_id") UUID user_id);

    //Lend
    @GET("/api/user/lends/{user_id}")
    Single<List<Lend>> getLends(@Path("user_id") UUID user_id);

    @POST("/api/user/lend/{user_id}")
    Single<Lend> createLend(@Path("user_id") UUID user_id);

    @DELETE("/api/user/lend/{user_id}")
    void deleteLend(@Path("user_id") UUID user_id);

    //Voucher
    @GET("/api/user/vouchers/{user_id}")
    Single<List<Voucher>> getVouchers(@Path("user_id") UUID user_id);

    @GET("/api/user/vouchers/{id}")
    Single<VoucherProfile> getVoucherProfile(@Path("id") UUID id);
}
