package k15hkii.se114.bookstore.data.remote;

import java.util.List;
import java.util.UUID;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.*;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.bill.Transporter;
import k15hkii.se114.bookstore.data.model.api.book.Author;
import k15hkii.se114.bookstore.data.model.api.book.Book;
import k15hkii.se114.bookstore.data.model.api.book.Publisher;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItem;
import k15hkii.se114.bookstore.data.model.api.cartitem.CartItemCRUDRequest;
import k15hkii.se114.bookstore.data.model.api.file.Image;
import k15hkii.se114.bookstore.data.model.api.file.Video;
import k15hkii.se114.bookstore.data.model.api.lend.Lend;
import k15hkii.se114.bookstore.data.model.api.lend.LendRequest;
import k15hkii.se114.bookstore.data.model.api.message.Feedback;
import k15hkii.se114.bookstore.data.model.api.message.FeedbackCRUDRequest;
import k15hkii.se114.bookstore.data.model.api.message.ReplyCRUDRequest;
import k15hkii.se114.bookstore.data.model.api.message.ReplyFeedback;
import k15hkii.se114.bookstore.data.model.api.user.*;
import k15hkii.se114.bookstore.data.model.api.voucher.Voucher;
import k15hkii.se114.bookstore.data.model.api.voucher.VoucherProfile;
import okhttp3.RequestBody;
import retrofit2.http.*;

public interface ModelRemote {

    //region User
    @GET("/api/user")
    Single<List<User>> getUsers();

    @GET("api/user/profile")
    Single<User> getSelfUser();

    @GET("/api/user/profile/{id}")
    Single<User> getUser(@Path("id") UUID id);

    //region RecentBook
    @GET("/api/user/recent/{user_id}")
    Single<List<Book>> getRecentBooks(@Path("user_id") UUID user_id);

    @POST("api/user/profile")
    Single<User> updateSelfUser(@Body ProfileUpdateRequest request);

    /**
     * Tạo hoặc cập nhật một sách gần đây
     *
     * @param user_id
     * @param request
     * @return
     */
    @POST("/api/user/recent/{user_id}")
    Single<Book> createRecentBook(@Path("user_id") UUID user_id, @Body RecentBookCRUDRequest request);
    //endregion

    //region FavouriteBook
    @GET("/api/user/favourites/{user_id}")
    Single<List<Book>> getFavoriteBooks(@Path("user_id") UUID user_id);

    @GET("/api/user/favourite/{book_id}/{user_id}")
    Single<CRUDItemResponse<Boolean>> isFavouriteBook(@Path("user_id") UUID user_id, @Path("book_id") UUID book_id);

    /**
     * Tạo hoặc cập nhật một sách yêu thích
     *
     * @param user_id
     * @param request
     * @return
     */
    @POST("/api/user/favourite/{user_id}")
    Single<CRUDStatusResponse> createFavoriteBook(@Path("user_id") UUID user_id, @Body FavouriteBookCRUDRequest request);

    @DELETE("/api/user/favourite/{book_id}/{user_id}")
    Single<CRUDStatusResponse> deleteFavoriteBook(@Path("user_id") UUID user_id, @Path("book_id") UUID book_id);
    //endregion

    //region CartItem
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
    Single<CRUDStatusResponse> createCart(@Path("user_id") UUID user_id, @Body CartItemCRUDRequest cartItem);

    @DELETE("/api/user/cart/{book_id}")
    Single<CRUDStatusResponse> deleteCart(@Path("book_id") UUID book_id);
    //endregion

    //region Address
    @GET("/api/user/addresses/{user_id}")
    Single<List<UserAddress>> getAddresses(@Path("user_id") UUID user_id);

    @GET("/api/user/address/{address_id}/{user_id}")
    Single<UserAddress> getAddress(@Path("user_id") UUID user_id, @Path("address_id") long address_id);

    @DELETE("/api/user/address/{address_id}/{user_id}")
    Single<CRUDStatusResponse> deleteAddress(@Path("user_id") UUID user_id, @Path("address_id") long address_id);

    @POST("/api/user/address/{user_id}")
    Single<CRUDItemResponse<UserAddress>> createAddress(@Path("user_id") UUID user_id, @Body UserAddressCRUDRequest address);

    @POST("/api/user/address/{address_id}/{user_id}")
    Single<CRUDItemResponse<UserAddress>> updateAddress(@Path("user_id") UUID user_id, @Path("address_id") long address_id, @Body UserAddressCRUDRequest address);

    //region Bank
    @GET("/api/user/banks/{user_id}")
    Single<List<UserBank>> getBanks(@Path("user_id") UUID user_id);

    @POST("/api/user/bank/{user_id}")
    Single<CRUDItemResponse<UserBank>> createBank(@Path("user_id") UUID user_id, @Body UserBankCRUDRequest bank);

    @POST("/api/user/bank/{bank_id}/{user_id}")
    Single<CRUDItemResponse<UserBank>> updateBank(@Path("user_id") UUID user_id, @Path("bank_id") long bankId, @Body UserBankCRUDRequest bank);

    @GET("/api/user/bank/{bank_id}/{user_id}")
    Single<UserBank> getBank(@Path("user_id") UUID user_id, @Path("bank_id") long bank_id);

    @DELETE("/api/user/bank/{bank_id}/{user_id}")
    Single<CRUDStatusResponse> deleteBank(@Path("user_id") UUID user_id, @Path("bank_id") long bank_id);
    //endregion
    //endregion
    //endregion

    //region Author
    @GET("/api/author/{id}")
    Single<Author> getAuthor(@Path("id") int id);

    @GET("/api/author")
    Single<List<Author>> getAuthors();
    //endregion

    //region Book
    @GET("/api/book/search")
    Single<List<Book>> getBooks();

    @GET("/api/book/search")
    Single<List<Book>> getBooks(@Query("search") String search);

    @GET("/api/book/info/{book_id}")
    Single<Book> getBook(@Path("book_id") UUID id);

    @GET("/api/statistic/book/{book_id}/sold")
    Single<StatisticResult> getOneBookSold(@Path("book_id") UUID id);

    @GET("/api/statistic/book/sold")
    Single<StatisticResult> getBookSolds();

    @GET("/api/statistic/book/{book_id}/rate")
    Single<StatisticResult> getBookRate(@Path("book_id") UUID id);
    //endregion

    //region Publisher
    @GET("/api/publisher/{id}")
    Single<Publisher> getPublisher(@Path("id") int id);

    @GET("/api/publisher")
    Single<List<Publisher>> getPublishers();
    //endregion

    //region Transporter
    @GET("/api/transporter/{id}")
    Single<Transporter> getTransporter(@Path("id") int id);

    @GET("/api/transporter")
    Single<List<Transporter>> getTransporters();
    //endregion

    //region Bill
    @GET("/api/bill/{bill_id}")
    Single<Bill> getBill(@Path("bill_id") int id);

    @GET("/api/bill/{bill_id}/vouchers")
    Single<List<VoucherProfile>> getBillVouchers(@Path("bill_id") int bill_id);

    @GET("/api/user/bills/{user_id}")
    Single<List<Bill>> getBills(@Path("user_id") UUID user_id);

//    @GET("/api/bill/from/{user_id}")
//    Single<List<Bill>> getBills(@Path("user_id") UUID user_id);

    @POST("/api/bill/{bill_id}")
    Single<Bill> createBill(@Path("bill_id") int bill_id);

    /**
     * Cancel order
     *
     * @param user_id
     * @param billId
     */
    @DELETE("/api/user/bill/{user_id}")
    Single<Integer> deleteBill(@Path("user_id") UUID user_id, int billId);
    //endregion

    //region Lend
    @GET("/api/lend/from/{user_id}")
    Single<List<Lend>> getLends(@Path("user_id") UUID user_id);

//    @GET("/api/user/lend/{user_id}")
//    Single<List<Lend>> getLends(@Path("user_id") UUID user_id);

    @GET("/api/lend/{lend_id}")
    Single<Lend> getLend(@Path("lend_id") UUID lend_id);

    @POST("/api/user/lend/{user_id}")
    Single<Lend> createLend(@Path("user_id") UUID user_id, @Body LendRequest request);

    @DELETE("/api/user/lend/{user_id}")
    void deleteLend(@Path("user_id") UUID user_id);
    //endregion

    //region Voucher
    @GET("/api/voucher/profile/{profile_id}")
    Single<VoucherProfile> getVoucherProfile(@Path("profile_id") UUID id);

    @GET("/api/user/vouchers/{user_id}")
    Single<List<Voucher>> getVouchers(@Path("user_id") UUID user_id);

    @GET("/api/voucher/profiles")
    Single<List<VoucherProfile>> getVoucherProfiles();

    @GET("/api/voucher/{voucher_id}")
    Single<Voucher> getVoucher(@Path("voucher_id") UUID voucher_id);
    //endregion

    //region File
    @Multipart
    @POST("/upload/image")
    Single<Image> uploadImage(@Part RequestBody body);

    @Multipart
    @POST("/upload/video")
    Single<Video> uploadVideo(@Part RequestBody body);
    //endregion

    //region Feedback
    @GET("/api/message/feedback/{book_id}")
    Single<List<Feedback>> getFeedbacks(@Path("book_id") UUID book_id);

    @POST("/api/message/feedback")
    public Single<Feedback> sendFeedback(@Body FeedbackCRUDRequest feedback);

    @POST("/api/message/{feedback_id}")
    public Single<ReplyFeedback> sendReply(@Body ReplyCRUDRequest request);
    //endregion

}
