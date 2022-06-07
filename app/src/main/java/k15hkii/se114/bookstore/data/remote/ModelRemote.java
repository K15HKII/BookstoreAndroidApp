package k15hkii.se114.bookstore.data.remote;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.*;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.model.api.lend.LendRequest;
import k15hkii.se114.bookstore.data.model.api.user.FavouriteBookCRUDRequest;
import k15hkii.se114.bookstore.data.model.api.user.RecentBookCRUDRequest;
import k15hkii.se114.bookstore.data.model.api.user.UserAddressCRUDRequest;
import k15hkii.se114.bookstore.data.model.api.user.UserBankCRUDRequest;
import retrofit2.http.*;

import java.util.Date;
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

    @GET("/api/author")
    Single<List<Author>> getAuthors();

    //Book
    @GET("/api/book/search")
    Single<List<Book>> getBooks();

    @GET("/api/book/info/{id}")
    Single<Book> getBook(@Path("id") UUID id);

    //Publisher
    @GET("/api/publisher/{id}")
    Single<Publisher> getPublisher(@Path("id") int id);

    void deletePublisher(@Path("id") int id);

    @GET("/api/publisher")
    Single<List<Publisher>> getPublishers();

    //Transporter
    @GET("/api/transporter/{id}")
    Single<Transporter> getTransporter(@Path("id") int id);

    @GET("/api/transporter")
    Single<List<Transporter>> getTransporters();

    //User
    //RecentBook
    @GET("/api/user/recents/{user_id}")
    Single<List<Book>> getRecentBooks(@Path("user_id") UUID user_id);

    /**
     *
     * Tạo hoặc cập nhật một sách gần đây
     *
     * @param user_id
     * @param request
     * @return
     */
    @POST("/api/user/recent/{user_id}")
    Single<Book> createRecentBook(@Path("user_id") UUID user_id, @Body RecentBookCRUDRequest request);

    //FavoriteBook
    @GET("/api/user/favourites/{user_id}")
    Single<List<Book>> getFavoriteBooks(@Path("user_id") UUID user_id);

    /**
     *
     * Tạo hoặc cập nhật một sách yêu thích
     *
     * @param user_id
     * @param request
     * @return
     */
    @POST("/api/user/favourite/{user_id}")
    Single<Book> createFavoriteBook(@Path("user_id") UUID user_id, @Body FavouriteBookCRUDRequest request);

    @DELETE("/api/user/favourite/{user_id}")
    void deleteFavoriteBook(@Path("user_id") UUID user_id, @Body FavouriteBookCRUDRequest request);
    //CartItem
    @GET("/api/user/carts/{user_id}")
    Single<List<CartItem>> getCarts(@Path("user_id") UUID user_id);

    /**
     *
     * Tạo hoặc cập nhật CartItem
     *
     * @param user_id
     * @param cartItem
     * @return
     */
    @POST("/api/user/cart/{user_id}")
    Single<CartItem> createCart(@Path("user_id") UUID user_id, @Body CartItem cartItem);

    @DELETE("/api/user/cart/{user_id}")
    void deleteCart(@Path("user_id") UUID user_id, @Body String book_id);

    //Bill
    @GET("/api/bill/{id}")
    Single<Bill> getBill(@Path("id") int id);

    @GET("/api/user/bills/{user_id}")
    Single<List<Bill>> getBills(@Path("user_id") UUID user_id);

    @POST("/api/user/bill/{user_id}")
    Single<Bill> createBill(@Path("user_id") UUID user_id);

    /**
     *
     * Cancel order
     *
     * @param user_id
     * @param billId
     */
    @DELETE("/api/user/bill/{user_id}")
    void deleteBill(@Path("user_id") UUID user_id, int billId);

    //Address
    @GET("/api/user/addresses/{user_id}")
    Single<List<UserAddress>> getAddresses(@Path("user_id") UUID user_id);

    @POST("/api/user/address/{user_id}")
    Single<UserAddress> createAddress(@Path("user_id") UUID user_id, @Body UserAddressCRUDRequest address);

    @DELETE("/api/user/address/{user_id}")
    void deleteAddress(@Path("user_id") UUID user_id, @Body Date date);

    //Bank
    @GET("/api/user/banks/{user_id}")
    Single<List<UserBank>> getBanks(@Path("user_id") UUID user_id);

    @POST("/api/user/bank/{user_id}")
    Single<UserBank> createBank(@Path("user_id") UUID user_id, @Body UserBankCRUDRequest bank);

    @DELETE("/api/user/bank/{user_id}")
    void deleteBank(@Path("user_id") UUID user_id, @Body Date date);

    //Lend
    @GET("/api/user/lends/{user_id}")
    Single<List<Lend>> getLends(@Path("user_id") UUID user_id);

    @POST("/api/user/lend/{user_id}")
    Single<Lend> createLend(@Path("user_id") UUID user_id, @Body LendRequest request);

    @DELETE("/api/user/lend/{user_id}")
    void deleteLend(@Path("user_id") UUID user_id);

    //Voucher
    @GET("/api/user/vouchers/{user_id}")
    Single<List<Voucher>> getVouchers(@Path("user_id") UUID user_id);

    @GET("/api/user/vouchers/{id}")
    Single<VoucherProfile> getVoucherProfile(@Path("id") UUID id);
}
