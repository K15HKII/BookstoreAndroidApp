package k15hkii.se114.bookstore.data.remote;

import android.os.Build;
import androidx.annotation.RequiresApi;
import io.reactivex.Observable;
import io.reactivex.Single;
import k15hkii.se114.bookstore.data.model.api.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@RequiresApi(api = Build.VERSION_CODES.N)
public class LocalModelRemote implements ModelRemote {

    private List<User> users = Arrays.asList(
            new User().withId(UUID.fromString("1"))
                    .withEmail("2"),
            new User().withEmail("3")
    );

    private List<UserAddress> userAddresss = Arrays.asList(
            new UserAddress().withUserId(UUID.fromString("U1")).withCountry("123").withCity("HCM"),
            new UserAddress().withUserId(UUID.fromString("U2")).withCountry("456").withCity("Dong Nai"),
            new UserAddress().withUserId(UUID.fromString("U3")).withCountry("789").withCity("Tra Vinh")
    );
    private List<Author> authors = Arrays.asList(
            new Author().withId(1).withName("Ngoc Trinh"),
            new Author().withId(2).withName("Vu Khac Tiep"),
            new Author().withId(3).withName("Thay Giao Ba")
    );
    private List<VoucherProfile> voucherProfiles = Arrays.asList(
            new VoucherProfile().withId(UUID.fromString("VP1")),
            new VoucherProfile().withId(UUID.fromString("VP2")),
            new VoucherProfile().withId(UUID.fromString("VP3"))
    );
    private List<Book> books = Arrays.asList(
            new Book().withId(UUID.fromString("BP1")).withTitle("dark nhan tam"),
            new Book().withId(UUID.fromString("BP2")).withTitle("huhu"),
            new Book().withId(UUID.fromString("BP3")).withTitle("hihi")
    );
    private List<Publisher> publishers = Arrays.asList(
            new Publisher().withId(1).withName("Lmao"),
            new Publisher().withId(2).withName("Khoc"),
            new Publisher().withId(3).withName("Cuoi")
    );
    private List<Transporter> transporters = Arrays.asList(
            new Transporter().withId(1).withName("Khoi Chim Be"),
            new Transporter().withId(2).withName("Tri Map"),
            new Transporter().withId(3).withName("Quoc 20cm")
    );
    private List<Transport> transports = Arrays.asList(
            new Transport().withId(UUID.fromString("T1")),
            new Transport().withId(UUID.fromString("T2")),
            new Transport().withId(UUID.fromString("T3"))
    );
    private List<Lend> lends = Arrays.asList(
            new Lend().withId(UUID.fromString("L1")).withBook(new Book()),
            new Lend().withId(UUID.fromString("L2")).withBook(new Book()),
            new Lend().withId(UUID.fromString("L3")).withBook(new Book())
    );
    private List<Voucher> vouchers = Arrays.asList(
            new Voucher().withId(UUID.fromString("V1")),
            new Voucher().withId(UUID.fromString("V2")),
            new Voucher().withId(UUID.fromString("V3"))
    );
    private List<WildVoucher> wildVouchers = Arrays.asList(
            new WildVoucher().withId(UUID.fromString("WV1")).withMaxUses(1),
            new WildVoucher().withId(UUID.fromString("WV2")).withMaxUses(1),
            new WildVoucher().withId(UUID.fromString("WV3")).withMaxUses(1)
    );
    private List<Bill> bills = Arrays.asList(
            new Bill().withId(1).withUserid(UUID.fromString("U1")),
            new Bill().withId(2).withUserid(UUID.fromString("U2")),
            new Bill().withId(3).withUserid(UUID.fromString("U3"))
    );
    private List<BillDetail> billDetails = Arrays.asList(
            new BillDetail().withBillId(1).withPrice(69696969),
            new BillDetail().withBillId(2).withPrice(96969696),
            new BillDetail().withBillId(3).withPrice(0)
    );

    private List<File> bookFileImages = Arrays.asList(
            new Image().withId(UUID.fromString("BPI1")).withPath(null),
            new Image().withId(UUID.fromString("BPI2")).withPath(null),
            new Image().withId(UUID.fromString("BPI3")).withPath(null)
    );

    List<Image> transferFiletoImage(List<File> files) {
        List<Image> images = new ArrayList<>();
        for (File file : files) {
            images.add((Image) file);
        }
        return images;
    };
    private List<Image> bookImages = transferFiletoImage(bookFileImages);
    private List<CartItem> cartItems = Arrays.asList(
            new CartItem().withUserId(UUID.fromString("U1")).withBookId(UUID.fromString("B1")),
            new CartItem().withUserId(UUID.fromString("U2")).withBookId(UUID.fromString("B2")),
            new CartItem().withUserId(UUID.fromString("U3")).withBookId(UUID.fromString("B3"))
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
    public Single<User> getSelfUser() {
        return null;
    }

    @Override
    public Single<User> getUser(String id) {
        User res = null;
        for (User user : users) {
            if (id.equalsIgnoreCase(user.getId().toString())) {
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
            if (id.equalsIgnoreCase(userAddress.getUserId().toString())) {
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
            if (id.equalsIgnoreCase(String.valueOf(author.getId()))) {
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
            if (id.equalsIgnoreCase(voucherprofile.getId().toString())) {
                res = voucherprofile;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<Book> getBook(String id) {
        Book res = null;
        for (Book book : books) {
            if (id.equalsIgnoreCase(book.getId().toString())) {
                res = book;
                break;
            }
        }
        return single(res);
    }

    @Override
    public Single<List<Image>> getBookImages() {
        return single(bookImages);
    }

    @Override
    public Single<Image> getBookImage(String id, int i) {
        Image res = null;
        for (File bookImage : bookImages) {
            if (id.equalsIgnoreCase(bookImage.getId().toString())) {
                res = (Image) bookImage;
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
            if (id.equalsIgnoreCase(transport.getId().toString())) {
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
            if (id.equalsIgnoreCase(String.valueOf(publisher.getId()))) {
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
            if (id.equalsIgnoreCase(String.valueOf(transporter.getId()))) {
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
    public Single<CartItem> getCartitem(String userId, String bookId) {
        CartItem res = null;
        for (CartItem cartItem : cartItems) {
            if (userId.equalsIgnoreCase(cartItem.getUserId().toString()) && bookId.equalsIgnoreCase(cartItem.getBookId().toString())) {
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
    public Single<List<Bill>> getBills() {
        return single(bills);
    }

    @Override
    public Single<Bill> getBill(String id) {
        Bill res = null;
        for (Bill bill : bills) {
            if (id.equalsIgnoreCase(String.valueOf(bill.getId()))) {
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
            if (id.equalsIgnoreCase(lend.getId().toString())) {
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
            if (id.equalsIgnoreCase(voucher.getId().toString())) {
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
            if (id.equalsIgnoreCase(wildVoucher.getId().toString())) {
                res = wildVoucher;
                break;
            }
        }
        return single(res);
    }
}
