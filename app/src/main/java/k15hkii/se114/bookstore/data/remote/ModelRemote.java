package k15hkii.se114.bookstore.data.remote;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.*;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItemCRUDRequest;
import k15hkii.se114.bookstore.data.model.api.lend.LendRequest;
import k15hkii.se114.bookstore.data.model.api.user.FavouriteBookCRUDRequest;
import k15hkii.se114.bookstore.data.model.api.user.RecentBookCRUDRequest;
import k15hkii.se114.bookstore.data.model.api.user.User;
import k15hkii.se114.bookstore.data.model.api.user.UserAddress;
import k15hkii.se114.bookstore.data.model.api.user.UserAddressCRUDRequest;
import k15hkii.se114.bookstore.data.model.api.user.UserBank;
import k15hkii.se114.bookstore.data.model.api.user.UserBankCRUDRequest;
import okhttp3.RequestBody;
import retrofit2.http.*;

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

    @GET("/api/book/info/{book_id}")
    Single<Book> getBook(@Path("book_id") UUID id);

    //BookSold
    @GET("/api/statistic/book/{book_id}/sold")
    Single<StatisticResult> getOneBookSold(@Path("book_id") UUID id);

    @GET("/api/statistic/book/sold")
    Single<StatisticResult> getBookSolds();

    //BookRate
    @GET("/api/statistic/book/{book_id}/rate")
    Single<StatisticResult> getBookRate(@Path("book_id") UUID id);

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
    @GET("/api/user/recent/{user_id}")
    Single<List<Book>> getRecentBooks(@Path("user_id") UUID user_id);

    /**
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
     * Tạo hoặc cập nhật CartItem
     *
     * @param user_id
     * @param cartItem
     * @return
     */
    @POST("/api/user/cart/{user_id}")
    Single<CartItem> createCart(@Path("user_id") UUID user_id, @Body CartItemCRUDRequest cartItem);

    @DELETE("/api/user/cart/{book_id}")
    void deleteCart(@Path("book_id") UUID book_id);

    //Bill
    @GET("/api/bill/{bill_id}")
    Single<Bill> getBill(@Path("bill_id") int id);

    @GET("/api/bill/{bill_id}/vouchers")
    Single<List<VoucherProfile>> getBillVouchers(@Path("bill_id") int bill_id);

    @GET("/api/bill/from/{user_id}")
    Single<List<Bill>> getBills(@Path("user_id") UUID user_id);

    @POST("/api/bill/{bill_id}")
    Single<Bill> createBill(@Path("bill_id") int bill_id);



    /**
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

    @GET("/api/user/address/{address_id}/{user_id}")
    Single<UserAddress> getAddress(@Path("user_id") UUID user_id, @Path("address_id") long address_id);

    @DELETE("/api/user/address/{address_id}/{user_id}")
    void deleteAddress(@Path("user_id") UUID user_id, @Path("address_id") long address_id);

    @POST("/api/user/address/{user_id}")
    Single<UserAddress> createAddress(@Path("user_id") UUID user_id, @Body UserAddressCRUDRequest address);

    @POST("/api/user/address/{address_id}/{user_id}")
    Single<UserAddress> updateAddress(@Path("user_id") UUID user_id, @Path("address_id") long address_id, @Body UserAddressCRUDRequest address);

    //Bank
    @GET("/api/user/banks/{user_id}")
    Single<List<UserBank>> getBanks(@Path("user_id") UUID user_id);

    @POST("/api/user/bank/{user_id}")
    Single<UserBank> createBank(@Path("user_id") UUID user_id, @Body UserBankCRUDRequest bank);

    @POST("/api/user/bank/{bank_id}/{user_id}")
    Single<UserBank> updateBank(@Path("user_id") UUID user_id, @Path("bank_id") long bankId, @Body UserBankCRUDRequest bank);

    @GET("/api/user/bank/{bank_id}/{user_id}")
    Single<List<UserBank>> getBank(@Path("user_id") UUID user_id, @Path("bank_id") long bank_id);

    @DELETE("/api/user/bank/{bank_id}/{user_id}")
    void deleteBank(@Path("user_id") UUID user_id, @Path("bank_id") long bank_id);

    //Lend
    @GET("/api/lend/from/{user_id}")
    Single<List<Lend>> getLends(@Path("user_id") UUID user_id);

    @GET("/api/lend/{lend_id}")
    Single<Lend> getLend(@Path("lend_id") UUID lend_id);

    @POST("/api/user/lend/{user_id}")
    Single<Lend> createLend(@Path("user_id") UUID user_id, @Body LendRequest request);

    @DELETE("/api/user/lend/{user_id}")
    void deleteLend(@Path("user_id") UUID user_id);

    //Voucher
    @GET("/api/voucher/profile/{profile_id}")
    Single<VoucherProfile> getVoucherProfile(@Path("profile_id") UUID id);

    @GET("/api/voucher/profiles")
    Single<List<VoucherProfile>> getVoucherProfiles();

    @GET("/api/voucher/{voucher_id}")
    Single<Voucher> getVoucher(@Path("voucher_id") Date usedAt);

    @Multipart
    @POST("/upload/image")
    Single<Image> uploadImage(@Part RequestBody body);

    @Multipart
    @POST("/upload/video")
    Single<Video> uploadVideo(@Part RequestBody body);

}
