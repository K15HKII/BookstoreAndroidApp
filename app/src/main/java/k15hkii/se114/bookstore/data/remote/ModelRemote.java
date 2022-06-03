package k15hkii.se114.bookstore.data.remote;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.*;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;
import java.util.UUID;

public interface ModelRemote {

    @GET("/api/book/search")
    Single<List<Book>> getBooks();

    @GET("/api/book/info/{id}")
    Single<Book> getBook(UUID id);

    @GET("/api/model/user")
    Single<List<User>> getUsers();

    @GET("api/mode/user/self")
    Single<User> getSelfUser();

    @GET("/api/model/user/{id}")
    Single<User> getUser(String id);

    @GET("/api/user/banks/{user_id}")
    Single<List<UserBank>> getUserBanks(String id);

    @GET("/api/user/addresses/{user_id}")
    Single<List<UserAddress>> getUserAddresses(String id);

    //Author
    @GET("/api/author/{id}")
    Single<Author> getAuthor();

    @POST("api/author/{id}")
    Single<Author> updateAuthor();

    @DELETE("api/author/{id}")
    void deleteAuthor();

    @GET("/api/author")
    Single<List<Author>> getAuthors();

    @POST("api/author")
    Single<Author> createAuthor();
    //Book

    //Publisher
    @GET("/api/publisher/{id}")
    Single<Publisher> getPublisher();

    @POST("api/publisher/{id}")
    Single<Publisher> updatePublisher();

    @DELETE("api/publisher/{id}")
    void deletePublisher();

    @GET("/api/publisher")
    Single<List<Publisher>> getPublishers();

    @POST("api/publisher")
    Single<Publisher> createPublisher();

    //Transporter
    @GET("/api/transporter/{id}")
    Single<Transporter> getTransporter();

    @POST("api/transporter/{id}")
    Single<Transporter> updateTransporter();

    @DELETE("api/transporter/{id}")
    void deleteTransporter();

    @GET("/api/transporter")
    Single<List<Transporter>> getTransporters();

    @POST("api/transporter")
    Single<Transporter> createTransporter();

    //User
    //RecentBook
    @GET("/api/user/recents/{user_id}")
    Single<List<Book>> getRecentBooks();

    @POST("/api/user/recent/{user_id}")
    Single<Book> createRecentBook();

    //FavoriteBook
    @GET("/api/user/favorites/{user_id}")
    Single<List<Book>> getFavoriteBooks();

    @POST("/api/user/favorite/{user_id}")
    Single<Book> createFavoriteBook();

    @DELETE("/api/user/favorite/{user_id}")
    void deleteFavoriteBook();
    //CartItem
    @GET("/api/user/carts/{user_id}")
    Single<List<CartItem>> getCarts(String user_id);

    @POST("/api/user/cart/{user_id}")
    Single<CartItem> createCart();

    @DELETE("/api/user/cart/{user_id}")
    void deleteCart();

    //Bill
    @GET("/api/bill/{id}")
    Single<Bill> getBill(int billId);

    @GET("/api/user/bills/{user_id}")
    Single<List<Bill>> getBills();

    @POST("/api/user/bill/{user_id}")
    Single<Bill> createBill();

    @DELETE("/api/user/bill/{user_id}")
    void deleteBill();

    //Address
    @GET("/api/user/addresses/{user_id}")
    Single<List<UserAddress>> getAddresss();

    @POST("/api/user/address/{user_id}")
    Single<UserAddress> createAddress();

    @DELETE("/api/user/address/{user_id}")
    void deleteAddress();

    //Bank
    @GET("/api/user/banks/{user_id}")
    Single<List<UserBank>> getBanks();

    @POST("/api/user/bank/{user_id}")
    Single<UserBank> createBank();

    @DELETE("/api/user/bank/{user_id}")
    void deleteBank();

    //Lend
    @GET("/api/user/lends/{user_id}")
    Single<List<Lend>> getLends();

    @POST("/api/user/lend/{user_id}")
    Single<Lend> createLend();

    @DELETE("/api/user/lend/{user_id}")
    void deleteLend();

    //Voucher
    @GET("/api/user/vouchers/{user_id}")
    Single<List<Voucher>> getVouchers();
}
