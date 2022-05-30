package k15hkii.se114.bookstore.data.remote;

import io.reactivex.Observable;
import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.*;

import java.util.Arrays;
import java.util.List;

public class LocalModelRemote implements ModelRemote {

    private List<User> users = Arrays.asList(
            new User().withId("a")
                    .withEmail(2),
            new User().withEmail(1)
    );

    public LocalModelRemote() {

    }

    private <T> Single<T> single(T o) {
        return Single.fromObservable(Observable.just(o));
    }

    @Override
    public Single<List<User>> getUsers() {
        return single(users);
    }

    @Override
    public Single<User> getUser(String id) {
        User res = null;
        for (User user : users) {
            if (id.equalsIgnoreCase(user.getId())) {
                res = user;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<User> saveUser(Object obj) {
        return single(null);
    }

    @Override
    public Single<List<UserAddress>> getUseraddresses() {
        return null;
    }

    @Override
    public Single<UserAddress> getUseraddress(String id, String index) {
        return null;
    }

    @Override
    public Single<UserAddress> saveUseraddress(Object obj) {
        return null;
    }

    @Override
    public Single<List<Author>> getAuthors() {
        return null;
    }

    @Override
    public Single<Author> getAuthor(String id) {
        return null;
    }

    @Override
    public Single<List<VoucherProfile>> getVoucherProfiles() {
        return null;
    }

    @Override
    public Single<VoucherProfile> getVoucherProfile(String id) {
        return null;
    }

    @Override
    public Single<List<BookProfile>> getBookprofiles() {
        return null;
    }

    @Override
    public Single<BookProfile> getBookprofile(String id) {
        return null;
    }

    @Override
    public Single<List<BookProfileImage>> getBookprofileimages() {
        return null;
    }

    @Override
    public Single<BookProfileImage> getBookprofileimage(String id, int i) {
        return null;
    }

    @Override
    public Single<List<Transport>> getTransports() {
        return null;
    }

    @Override
    public Single<Transport> getTransport(String id) {
        return null;
    }

    @Override
    public Single<List<Publisher>> getPublishers() {
        return null;
    }

    @Override
    public Single<Publisher> getPublisher(String id) {
        return null;
    }

    @Override
    public Single<List<Transporter>> getTransporters() {
        return null;
    }

    @Override
    public Single<Transporter> getTransporter(String id) {
        return null;
    }

    @Override
    public Single<List<CartItem>> getCartitems(String userId) {
        return null;
    }

    @Override
    public Single<CartItem> getCartitem(String userId, String bookProfileId) {
        return null;
    }

    @Override
    public Single<CartItem> saveCartitem(Object obj) {
        return null;
    }

    @Override
    public Single<CartItem> deleteCartitem(Object obj) {
        return null;
    }

    @Override
    public Single<List<Book>> getBooks() {
        return null;
    }

    @Override
    public Single<Book> getBook(String id) {
        return null;
    }

    @Override
    public Single<List<Bill>> getBills() {
        return null;
    }

    @Override
    public Single<Bill> getBill(String id) {
        return null;
    }

    @Override
    public Single<List<BillDetail>> getBilldetails(String billId) {
        return null;
    }

    @Override
    public Single<BillDetail> getBilldetail(String id, String bookId) {
        return null;
    }

    @Override
    public Single<List<Lend>> getLends() {
        return null;
    }

    @Override
    public Single<Lend> getLend(String id) {
        return null;
    }

    @Override
    public Single<List<Voucher>> getVouchers() {
        return null;
    }

    @Override
    public Single<Voucher> getVoucher(String id) {
        return null;
    }

    @Override
    public Single<List<WildVoucher>> getWildvouchers() {
        return null;
    }

    @Override
    public Single<WildVoucher> getWildvoucher(String id) {
        return null;
    }
}
