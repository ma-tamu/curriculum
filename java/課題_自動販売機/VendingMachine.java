import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class VendingMachine {

    public static void main(final String[] args) {
        final Drink tea = new Drink("code1", "お茶", 100);
        final Drink coffee = new Drink("code2", "コーヒー", 120);
        final Drink juice = new Drink("code3", "ジュース", 150);
        final List<Drink> drinkList = List.of(tea, coffee, juice);

        // 前提
        int deposit = 0;

        // 商品最低値
        final Drink minByDrink = drinkList.stream().min(Comparator.comparing(Drink::getPrice)).orElseThrow(NoSuchElementException::new);

        int lowestPrice = 0;
        lowestPrice = minByDrink.getPrice();
        int price = lowestPrice;

        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            // 入金処理
            deposit = depositProcess(br, price, deposit);

            // 商品メニュー表示
            drinkList.forEach(Drink::displayMenu);

            // 商品購入継続
            boolean IsContinueBuying = false;
            IsContinueBuying = continueBuying(br, IsContinueBuying);

            while (IsContinueBuying) {

                // 商品購入
                // 選択したドリンク表示
                final Drink selectProduct = select(drinkList, br);
                final int selectProductPrice = selectProduct.getPrice();
                final String selectProductName = selectProduct.getName();

                System.out.println(selectProductName + ":" + selectProductPrice + "円");
                price = selectProductPrice;

                // 入金処理
                if (deposit < price) {

                    deposit = depositProcess(br, price, deposit);

                }
                deposit -= selectProductPrice;

                System.out.println("{" + selectProductName + "]ご購入ありがとうございました。");

                if (lowestPrice <= deposit) {
                    System.out.println("残高は" + deposit + "です。");
                    IsContinueBuying = continueBuying(br, IsContinueBuying);

                } else {
                    IsContinueBuying = false;
                }
            }
            System.out.println("お釣りは" + deposit + "円です。");
            System.out.println("ご利用ありがとうございました。");
        } catch (final IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    // 入金処理のメソッド
    private static int depositProcess(final BufferedReader depositProcessBufferedReader, final int price, int deposit) throws NumberFormatException, IOException {
        int charge = 0;
        while (deposit < price) {
            System.out.print("お金を入れてください:");

            try {
                charge = Integer.parseInt(depositProcessBufferedReader.readLine());
                deposit += charge;
            } catch (final NumberFormatException e) {
                System.out.println("数字を入力してください。");
            }

            System.out.println(deposit + "円入っています");
        }

        return deposit;
    }

    // 商品購入継続のメソッド
    private static boolean continueBuying(final BufferedReader continueBuyingBufferedReader, final boolean IsContinueBuying) throws IOException {

        do {
            System.out.print("商品購入を行いますか？行わない場合はお釣りを返却します。YorN :");
            final String inputAnswer = continueBuyingBufferedReader.readLine();
            // キーボード入力を受け付ける
            if (inputAnswer.equals("Y")) {
                return true;
            } else if (inputAnswer.equals("N")) {
                return false;
            }
        } while (true);
    }

    // ドリンク選択のメソッド
    private static Drink select(final List<Drink> drinkList, final BufferedReader selectDrinkBufferedReader) throws IOException {
        Optional<Drink> selectProductOptinal = Optional.empty();
        drinkList.forEach(Drink::selectMenu);

        do {
            System.out.print("ドリンクのコードを入力してください。:");
            // キーボード入力を受け付ける
            final String inputCode = selectDrinkBufferedReader.readLine();
            selectProductOptinal = drinkList.stream().filter(drink -> {
                return inputCode.equals(drink.getCode());
            }).findFirst();

        } while (selectProductOptinal.isEmpty());
        return selectProductOptinal.get();
    }
}