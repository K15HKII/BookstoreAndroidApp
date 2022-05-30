package k15hkii.se114.bookstore.data.remote;

import io.reactivex.Observable;
import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.*;

import java.util.Arrays;
import java.util.List;

public class LocalModelRemote implements ModelRemote {

    private List<User> users = Arrays.asList(
            new User().withId("a")
                    .withEmail("2"),
            new User().withEmail("3")
    );

    private List<UserAddress> userAddresss = Arrays.asList(
            new UserAddress().withUserid("1").withAddress("123").withCity("HCM"),
            new UserAddress().withUserid("2").withAddress("456").withCity("Dong Nai"),
            new UserAddress().withUserid("3").withAddress("789").withCity("Tra Vinh")
    );
    private List<Author> authors = Arrays.asList(
            new Author().withId("1").withName("Ngoc Trinh"),
            new Author().withId("2").withName("Vu Khac Tiep"),
            new Author().withId("3").withName("Thay Giao Ba")
    );
    private List<VoucherProfile> voucherProfiles = Arrays.asList(
            new VoucherProfile().withId("1"),
            new VoucherProfile().withId("2"),
            new VoucherProfile().withId("3")
    );
    private List<BookProfile> bookProfiles = Arrays.asList(
            new BookProfile().withId("1").withName("dark nhan tam"),
            new BookProfile().withId("2").withName("huhu"),
            new BookProfile().withId("3").withName("hihi")
    );
    private List<Publisher> publishers = Arrays.asList(
            new Publisher().withId("1").withName("Lmao"),
            new Publisher().withId("2").withName("Khoc"),
            new Publisher().withId("3").withName("Cuoi")
    );
    private List<Transporter> transporters = Arrays.asList(
            new Transporter().withId("1").withName("Khoi Chim Be"),
            new Transporter().withId("2").withName("Tri Map"),
            new Transporter().withId("3").withName("Quoc 20cm")
    );
    private List<Transport> transports = Arrays.asList(
            new Transport().withId("1"),
            new Transport().withId("2"),
            new Transport().withId("3")
    );
    private List<Book> books = Arrays.asList(
            new Book().withId("1").withProfileId("01"),
            new Book().withId("2").withProfileId("02"),
            new Book().withId("3").withProfileId("03")
    );
    private List<Lend> lends = Arrays.asList(
            new Lend().withId("1").withUserid("1"),
            new Lend().withId("2").withUserid("2"),
            new Lend().withId("3").withUserid("3")
    );
    private List<Voucher> vouchers = Arrays.asList(
            new Voucher().withId("1").withUserid("1"),
            new Voucher().withId("2").withUserid("2"),
            new Voucher().withId("3").withUserid("3")
    );
    private List<WildVoucher> wildVouchers = Arrays.asList(
            new WildVoucher().withId("1").withProfileId("1"),
            new WildVoucher().withId("2").withProfileId("2"),
            new WildVoucher().withId("3").withProfileId("3")
    );
    private List<Bill> bills = Arrays.asList(
            new Bill().withId("1").withUserid("1"),
            new Bill().withId("2").withUserid("2"),
            new Bill().withId("3").withUserid("3")
    );
    private List<BillDetail> billDetails = Arrays.asList(
            new BillDetail().withBillId("1").withPrice(69696969),
            new BillDetail().withBillId("2").withPrice(96969696),
            new BillDetail().withBillId("3").withPrice(0)
    );
    private List<BookProfileImage> bookProfileImages = Arrays.asList(
            new BookProfileImage().withId("1").withImage(69696969),
            new BookProfileImage().withId("2").withImage(96969696),
            new BookProfileImage().withId("3").withImage(0)
    );
    private List<CartItem> cartItems = Arrays.asList(
            new CartItem().withUserid("1").withBookProfileid("1"),
            new CartItem().withUserid("2").withBookProfileid("2"),
            new CartItem().withUserid("3").withBookProfileid("3")
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
        return single(userAddresss);
    }

    @Override
    public Single<UserAddress> getUseraddress(String id, String index) {
        UserAddress res = null;
        for (UserAddress userAddress : userAddresss) {
            if (id.equalsIgnoreCase(userAddress.getUserid())) {
                res = userAddress;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<UserAddress> saveUseraddress(Object obj) {
        return null;
    }

    @Override
    public Single<List<Author>> getAuthors() {
        return single(authors);
    }

    @Override
    public Single<Author> getAuthor(String id) {
        Author res = null;
        for (Author author : authors) {
            if (id.equalsIgnoreCase(author.getId())) {
                res = author;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<List<VoucherProfile>> getVoucherProfiles() {
        return single(voucherProfiles);
    }

    @Override
    public Single<VoucherProfile> getVoucherProfile(String id) {
        VoucherProfile res = null;
        for (VoucherProfile voucherprofile : voucherProfiles) {
            if (id.equalsIgnoreCase(voucherprofile.getId())) {
                res = voucherprofile;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<List<BookProfile>> getBookprofiles() {
        return single(bookProfiles);
    }

    @Override
    public Single<BookProfile> getBookprofile(String id) {
        BookProfile res = null;
        for (BookProfile bookProfile : bookProfiles) {
            if (id.equalsIgnoreCase(bookProfile.getId())) {
                res = bookProfile;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<List<BookProfileImage>> getBookprofileimages() {
        return single(bookProfileImages);
    }

    @Override
    public Single<BookProfileImage> getBookprofileimage(String id, int i) {
        BookProfileImage res = null;
        for (BookProfileImage bookProfileImage : bookProfileImages) {
            if (id.equalsIgnoreCase(bookProfileImage.getId())) {
                res = bookProfileImage;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<List<Transport>> getTransports() {
        return single(transports);
    }

    @Override
    public Single<Transport> getTransport(String id) {
        Transport res = null;
        for (Transport transport : transports) {
            if (id.equalsIgnoreCase(transport.getId())) {
                res = transport;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<List<Publisher>> getPublishers() {
        return single(publishers);
    }

    @Override
    public Single<Publisher> getPublisher(String id) {
        Publisher res = null;
        for (Publisher publisher : publishers) {
            if (id.equalsIgnoreCase(publisher.getId())) {
                res = publisher;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<List<Transporter>> getTransporters() {
        return single(transporters);
    }

    @Override
    public Single<Transporter> getTransporter(String id) {
        Transporter res = null;
        for (Transporter transporter : transporters) {
            if (id.equalsIgnoreCase(transporter.getId())) {
                res = transporter;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<List<CartItem>> getCartitems(String userId) {
        return single(cartItems);
    }

    @Override
    public Single<CartItem> getCartitem(String userId, String bookProfileId) {
        CartItem res = null;
        for (CartItem cartItem : cartItems) {
            if (userId.equalsIgnoreCase(cartItem.getUserid()) && bookProfileId.equalsIgnoreCase(cartItem.getBookProfileid())) {
                res = cartItem;
                break;
            }
        }
        return single(res);
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
        return single(books);
    }

    @Override
    public Single<Book> getBook(String id) {
        Book res = null;
        for (Book book : books) {
            if (id.equalsIgnoreCase(book.getId())) {
                res = book;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<List<Bill>> getBills() {
        return single(bills);
    }

    @Override
    public Single<Bill> getBill(String id) {
        Bill res = null;
        for (Bill bill : bills) {
            if (id.equalsIgnoreCase(bill.getId())) {
                res = bill;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<List<Lend>> getLends() {
        return single(lends);
    }

    @Override
    public Single<Lend> getLend(String id) {
        Lend res = null;
        for (Lend lend : lends) {
            if (id.equalsIgnoreCase(lend.getId())) {
                res = lend;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<List<Voucher>> getVouchers() {
        return single(vouchers);
    }

    @Override
    public Single<Voucher> getVoucher(String id) {
        Voucher res = null;
        for (Voucher voucher : vouchers) {
            if (id.equalsIgnoreCase(voucher.getId())) {
                res = voucher;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<List<WildVoucher>> getWildvouchers() {
        return single(wildVouchers);
    }

    @Override
    public Single<WildVoucher> getWildvoucher(String id) {
        WildVoucher res = null;
        for (WildVoucher wildVoucher : wildVouchers) {
            if (id.equalsIgnoreCase(wildVoucher.getId())) {
                res = wildVoucher;
                break;
            }
        }
        return single(res);
    }
}
