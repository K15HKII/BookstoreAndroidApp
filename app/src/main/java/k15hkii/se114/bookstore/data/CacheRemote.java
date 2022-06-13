package k15hkii.se114.bookstore.data;

import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.ItemResponse;
import k15hkii.se114.bookstore.data.model.StatusResponse;
import k15hkii.se114.bookstore.data.model.api.StatisticResult;
import k15hkii.se114.bookstore.data.model.api.bill.Bill;
import k15hkii.se114.bookstore.data.model.api.bill.BillCreateRequest;
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
import k15hkii.se114.bookstore.data.model.auth.PasswordChangeRequest;
import k15hkii.se114.bookstore.data.remote.ModelRemote;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.*;

import java.util.*;

public class CacheRemote implements ModelRemote {

    private final ModelRemote remote;

    @Override
    @POST("/changepassword")
    public Single<StatusResponse> changePassword(PasswordChangeRequest request) {
        return remote.changePassword(request);
    }

    private final Map<UUID, Book> bookCache = new HashMap<>();
    private final List<Book> allBook = new ArrayList<>();

    @Override
    @GET("/api/user")
    public Single<List<User>> getUsers() {
        return remote.getUsers();
    }

    @Override
    @GET("api/user/profile")
    public Single<User> getSelfUser() {
        return remote.getSelfUser();
    }

    @Override
    @GET("/api/user/profile/{id}")
    public Single<User> getUser(UUID id) {
        return remote.getUser(id);
    }

    @Override
    @GET("/api/user/recent/{user_id}")
    public Single<List<Book>> getRecentBooks(UUID user_id) {
        return remote.getRecentBooks(user_id);
    }

    @Override
    @POST("api/user/profile")
    public Single<User> updateSelfUser(ProfileUpdateRequest request) {
        return remote.updateSelfUser(request);
    }

    @Override
    @POST("/api/user/recent/{user_id}")
    public Single<Book> createRecentBook(UUID user_id, RecentBookCRUDRequest request) {
        return remote.createRecentBook(user_id, request);
    }

    @Override
    @GET("/api/user/favourites/{user_id}")
    public Single<List<Book>> getFavoriteBooks(UUID user_id) {
        return remote.getFavoriteBooks(user_id);
    }

    @Override
    @GET("/api/user/favourite/{book_id}/{user_id}")
    public Single<ItemResponse<Boolean>> isFavouriteBook(UUID user_id, UUID book_id) {
        return remote.isFavouriteBook(user_id, book_id);
    }

    @Override
    @POST("/api/user/favourite/{user_id}")
    public Single<StatusResponse> createFavoriteBook(UUID user_id, FavouriteBookCRUDRequest request) {
        return remote.createFavoriteBook(user_id, request);
    }

    @Override
    @DELETE("/api/user/favourite/{book_id}/{user_id}")
    public Single<StatusResponse> deleteFavoriteBook(UUID user_id, UUID book_id) {
        return remote.deleteFavoriteBook(user_id, book_id);
    }

    @Override
    @GET("/api/user/carts/{user_id}")
    public Single<List<CartItem>> getCarts(UUID user_id) {
        return remote.getCarts(user_id);
    }

    @Override
    @POST("/api/user/cart/{user_id}")
    public Single<StatusResponse> createCart(UUID user_id, CartItemCRUDRequest cartItem) {
        return remote.createCart(user_id, cartItem);
    }

    @Override
    @DELETE("/api/user/cart/{book_id}")
    public Single<StatusResponse> deleteCart(UUID book_id) {
        return remote.deleteCart(book_id);
    }

    @Override
    @GET("/api/user/addresses/{user_id}")
    public Single<List<UserAddress>> getAddresses(UUID user_id) {
        return remote.getAddresses(user_id);
    }

    @Override
    @GET("/api/user/address/{address_id}/{user_id}")
    public Single<UserAddress> getAddress(UUID user_id, long address_id) {
        return remote.getAddress(user_id, address_id);
    }

    @Override
    @DELETE("/api/user/address/{address_id}/{user_id}")
    public Single<StatusResponse> deleteAddress(UUID user_id, long address_id) {
        return remote.deleteAddress(user_id, address_id);
    }

    @Override
    @POST("/api/user/address/{user_id}")
    public Single<ItemResponse<UserAddress>> createAddress(UUID user_id, UserAddressCRUDRequest address) {
        return remote.createAddress(user_id, address);
    }

    @Override
    @POST("/api/user/address/{address_id}/{user_id}")
    public Single<ItemResponse<UserAddress>> updateAddress(UUID user_id, long address_id, UserAddressCRUDRequest address) {
        return remote.updateAddress(user_id, address_id, address);
    }

    @Override
    @GET("/api/user/banks/{user_id}")
    public Single<List<UserBank>> getBanks(UUID user_id) {
        return remote.getBanks(user_id);
    }

    @Override
    @POST("/api/user/bank/{user_id}")
    public Single<ItemResponse<UserBank>> createBank(UUID user_id, UserBankCRUDRequest bank) {
        return remote.createBank(user_id, bank);
    }

    @Override
    @POST("/api/user/bank/{bank_id}/{user_id}")
    public Single<ItemResponse<UserBank>> updateBank(UUID user_id, long bankId, UserBankCRUDRequest bank) {
        return remote.updateBank(user_id, bankId, bank);
    }

    @Override
    @GET("/api/user/bank/{bank_id}/{user_id}")
    public Single<UserBank> getBank(UUID user_id, long bank_id) {
        return remote.getBank(user_id, bank_id);
    }

    @Override
    @DELETE("/api/user/bank/{bank_id}/{user_id}")
    public Single<StatusResponse> deleteBank(UUID user_id, long bank_id) {
        return remote.deleteBank(user_id, bank_id);
    }

    @Override
    @GET("/api/author/{id}")
    public Single<Author> getAuthor(int id) {
        return remote.getAuthor(id);
    }

    @Override
    @GET("/api/author")
    public Single<List<Author>> getAuthors() {
        return remote.getAuthors();
    }

    @Override
    @GET("/api/book/search")
    public Single<List<Book>> getBooks() {
        return !allBook.isEmpty() ? Single.just(new ArrayList<>(allBook)) : remote.getBooks().doOnSuccess(allBook::addAll);
    }

    @Override
    @GET("/api/book/search")
    public Single<List<Book>> getBooks(String search) {
        return remote.getBooks(search);
    }

    @Override
    @GET("/api/book/info/{book_id}")
    public Single<Book> getBook(UUID id) {
        return bookCache.containsKey(id) ? Single.just(bookCache.get(id)) : remote.getBook(id).doOnSuccess(book -> bookCache.put(id, book));
    }

    @Override
    @GET("/api/statistic/book/{book_id}/sold")
    public Single<StatisticResult> getOneBookSold(UUID id) {
        return remote.getOneBookSold(id);
    }

    @Override
    @GET("/api/statistic/book/sold")
    public Single<StatisticResult> getBookSolds() {
        return remote.getBookSolds();
    }

    @Override
    @GET("/api/statistic/book/{book_id}/rate")
    public Single<StatisticResult> getBookRate(UUID id) {
        return remote.getBookRate(id);
    }

    @Override
    @GET("/api/publisher/{id}")
    public Single<Publisher> getPublisher(int id) {
        return remote.getPublisher(id);
    }

    @Override
    @GET("/api/publisher")
    public Single<List<Publisher>> getPublishers() {
        return remote.getPublishers();
    }

    @Override
    @GET("/api/transporter/{id}")
    public Single<Transporter> getTransporter(int id) {
        return remote.getTransporter(id);
    }

    @Override
    @GET("/api/transporter")
    public Single<List<Transporter>> getTransporters() {
        return remote.getTransporters();
    }

    @Override
    @GET("/api/bill/{bill_id}")
    public Single<Bill> getBill(int id) {
        return remote.getBill(id);
    }

    @Override
    @GET("/api/bill/{bill_id}/vouchers")
    public Single<List<VoucherProfile>> getBillVouchers(int bill_id) {
        return remote.getBillVouchers(bill_id);
    }

    @Override
    @GET("/api/user/bills/{user_id}")
    public Single<List<Bill>> getBills(UUID user_id) {
        return remote.getBills(user_id);
    }

    @Override
    @POST("/api/user/bill/")
    public Single<Bill> createBill(BillCreateRequest request) {
        return remote.createBill(request);
    }

    @Override
    @DELETE("/api/user/bill/{user_id}")
    public Single<Integer> deleteBill(UUID user_id, int billId) {
        return remote.deleteBill(user_id, billId);
    }

    @Override
    @GET("/api/lend/from/{user_id}")
    public Single<List<Lend>> getLends(UUID user_id) {
        return remote.getLends(user_id);
    }

    @Override
    @GET("/api/lend/{lend_id}")
    public Single<Lend> getLend(UUID lend_id) {
        return remote.getLend(lend_id);
    }

    @Override
    @POST("/api/user/lend/{user_id}")
    public Single<Lend> createLend(UUID user_id, LendRequest request) {
        return remote.createLend(user_id, request);
    }

    @Override
    @DELETE("/api/user/lend/{user_id}")
    public void deleteLend(UUID user_id) {
        remote.deleteLend(user_id);
    }

    @Override
    @GET("/api/voucher/profile/{profile_id}")
    public Single<VoucherProfile> getVoucherProfile(UUID id) {
        return remote.getVoucherProfile(id);
    }

    @Override
    @GET("/api/user/vouchers/{user_id}")
    public Single<List<Voucher>> getVouchers(UUID user_id) {
        return remote.getVouchers(user_id);
    }

    @Override
    @GET("/api/voucher/profiles")
    public Single<List<VoucherProfile>> getVoucherProfiles() {
        return remote.getVoucherProfiles();
    }

    @Override
    @GET("/api/voucher/{voucher_id}")
    public Single<Voucher> getVoucher(UUID voucher_id) {
        return remote.getVoucher(voucher_id);
    }

    @Override
    @POST("/upload/image")
    @Headers({"Connection: keep-alive"
            , "Accept: */*"})
    @Multipart
    public Single<Image> uploadImage(MultipartBody.Part image) {
        return remote.uploadImage(image);
    }

    @Override
    @POST("/upload/video")
    @Multipart
    public Single<Video> uploadVideo(RequestBody body) {
        return remote.uploadVideo(body);
    }

    @Override
    @GET("/api/message/feedback/{book_id}")
    public Single<List<Feedback>> getFeedbacks(UUID book_id) {
        return remote.getFeedbacks(book_id);
    }

    @Override
    @GET("/api/message/feedbacks")
    public Single<List<Feedback>> getFeedbacks() {
        return remote.getFeedbacks();
    }

    @Override
    @POST("/api/message/feedback/{book_id}")
    public Single<Feedback> sendFeedback(UUID bookId, FeedbackCRUDRequest feedback) {
        return remote.sendFeedback(bookId, feedback);
    }

    @Override
    @POST("/api/message/{feedback_id}")
    public Single<ReplyFeedback> sendReply(ReplyCRUDRequest request) {
        return remote.sendReply(request);
    }

    public CacheRemote(ModelRemote remote) {
        this.remote = remote;
    }

}
