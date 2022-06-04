package k15hkii.se114.bookstore.data.remote;

import io.reactivex.Completable;
import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.*;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;

import java.util.List;
import java.util.UUID;

public interface ModelRemote {
    //User
    @GET("/api/model/user")
    Single<List<User>> getUsers();

    @GET("api/mode/user/self")
    Single<User> getSelfUser();

    @GET("/api/model/user/{id}")
    Single<User> getUser(UUID id);

    //Author
    @GET("/api/author/{id}")
    Single<Author> getAuthor(int id);

    @POST("api/author/{id}")
    Single<Author> updateAuthor(int id);

    @DELETE("api/author/{id}")
    void deleteAuthor(int id);

    @GET("/api/author")
    Single<List<Author>> getAuthors();

    @POST("api/author")
    Single<Author> createAuthor();
    //Book
    @GET("/api/book/search")
    Single<List<Book>> getBooks();

    @GET("/api/book/info/{id}")
    Single<Book> getBook(UUID id);

    //Publisher
    @GET("/api/publisher/{id}")
    Single<Publisher> getPublisher(int id);

    @POST("api/publisher/{id}")
    Single<Publisher> updatePublisher(int id);

    @DELETE("api/publisher/{id}")
    void deletePublisher(int id);

    @GET("/api/publisher")
    Single<List<Publisher>> getPublishers();

    @POST("api/publisher")
    Single<Publisher> createPublisher();

    //Transporter
    @GET("/api/transporter/{id}")
    Single<Transporter> getTransporter(int id);

    @POST("api/transporter/{id}")
    Single<Transporter> updateTransporter(int id);

    @DELETE("api/transporter/{id}")
    void deleteTransporter(int id);

    @GET("/api/transporter")
    Single<List<Transporter>> getTransporters();

    @POST("api/transporter")
    Single<Transporter> createTransporter();

    //User
    //RecentBook
    @GET("/api/user/recents/{user_id}")
    Single<List<Book>> getRecentBooks(UUID user_id);

    @POST("/api/user/recent/{user_id}")
    Single<Book> createRecentBook(UUID user_id);

    //FavoriteBook
    @GET("/api/user/favorites/{user_id}")
    Single<List<Book>> getFavoriteBooks(UUID user_id);

    @POST("/api/user/favorite/{user_id}")
    Single<Book> createFavoriteBook(UUID user_id);

    @DELETE("/api/user/favorite/{user_id}")
    void deleteFavoriteBook(UUID user_id);
    //CartItem
    @GET("/api/user/carts/{user_id}")
    Single<List<CartItem>> getCarts(UUID user_id);

    @POST("/api/user/cart/{user_id}")
    Single<CartItem> createCart(UUID user_id);

    @DELETE("/api/user/cart/{user_id}")
    void deleteCart(UUID user_id);

    //Bill
    @GET("/api/bill/{id}")
    Single<Bill> getBill(int billId);

    @GET("/api/user/bills/{user_id}")
    Single<List<Bill>> getBills(UUID user_id);

    @POST("/api/user/bill/{user_id}")
    Single<Bill> createBill(UUID user_id);

    @DELETE("/api/user/bill/{user_id}")
    void deleteBill(UUID user_id);

    //Address
    @GET("/api/user/addresses/{user_id}")
    Single<List<UserAddress>> getAddresses(UUID user_id);

    @POST("/api/user/address/{user_id}")
    Single<UserAddress> createAddress(UUID user_id);

    @DELETE("/api/user/address/{user_id}")
    void deleteAddress(UUID user_id);

    //Bank
    @GET("/api/user/banks/{user_id}")
    Single<List<UserBank>> getBanks(UUID user_id);

    @POST("/api/user/bank/{user_id}")
    Single<UserBank> createBank(UUID user_id);

    @DELETE("/api/user/bank/{user_id}")
    void deleteBank(UUID user_id);

    //Lend
    @GET("/api/user/lends/{user_id}")
    Single<List<Lend>> getLends(UUID user_id);

    @POST("/api/user/lend/{user_id}")
    Single<Lend> createLend(UUID user_id);

    @DELETE("/api/user/lend/{user_id}")
    void deleteLend(UUID user_id);

    //Voucher
    @GET("/api/user/vouchers/{user_id}")
    Single<List<Voucher>> getVouchers(UUID user_id);

    @GET("/api/user/vouchers/{user_id}")
    Single<VoucherProfile> getVoucherProfile(UUID id);
}
