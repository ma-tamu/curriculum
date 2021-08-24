import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

public class Drink2 {

    public static void main(final String[] args) {
        final Drink tea = new Drink("code1", "お茶", 100);
        final Drink coffee = new Drink("code2", "コーヒー", 120);
        final Drink juice = new Drink("code3", "ジュース", 150);
        final List<Drink> drinkList = List.of(tea, coffee, juice);

        // 前提
        int deposit = 0;
        int charge = 0;
        int lowestPrice = 0;
        int price = 0;

        // // final List<Integer> price = List.of(tea.getPrice(), coffee.getPrice(), juice.getPrice());
        // final List<Integer> priceList = drinkList.stream().map(drink -> drink.getPrice()).collect(Collectors.toList());
        // // ↑と↓は同じ意味 下の::はメソッド参照といった記述方式をしています
        // final List<Integer> priceList2 = drinkList.stream().map(Drink::getPrice).collect(Collectors.toList());

        // 商品最低値
        final Drink minByDrink = drinkList.stream().min(Comparator.comparing(Drink::getPrice)).orElseThrow(NoSuchElementException::new);

        lowestPrice = minByDrink.getPrice();
        price = lowestPrice;

        // 入金処理
        while (deposit < price) {

            charge = payment();
            deposit += charge;

            System.out.println(deposit + "円入っています");
        }

        // 商品メニュー表示
        tea.setMenu();
        coffee.setMenu();
        juice.setMenu();

        // 商品購入継続
        boolean IsContinueBuying = continueBuying();

        while (IsContinueBuying) {

            // 商品購入
            // 選択したドリンク表示
            final Drink selectProduct = select(drinkList);
            final int selectProductPrice = selectProduct.getPrice();
            final String selectProductName = selectProduct.getName();

            System.out.println(selectProductName + ":" + selectProductPrice + "円");
            price = selectProductPrice;

            // 入金処理
            if (deposit < price) {
                while (deposit < price) {

                    charge = payment();
                    deposit += charge;

                    System.out.println(deposit + "円入っています");
                }

            }
            deposit -= selectProductPrice;

            System.out.println("{" + selectProductName + "]ご購入ありがとうございました。");

            if (lowestPrice <= deposit) {
                System.out.println("残高は" + deposit + "です。");
                IsContinueBuying = continueBuying();

            } else {
                IsContinueBuying = false;
            }
        }
        System.out.println("お釣りは" + deposit + "円です。");
        System.out.println("ご利用ありがとうございました。");
    }

    // 入金処理のメソッド
    private static int payment() {
        final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("お金を入れてください:");

        try {
            // final キーボード入力を受け付ける
            return Integer.parseInt(br.readLine());

        } catch (final IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    // ドリンク選択のメソッド
    private static Drink select(final List<Drink> drinkList) {
        final BufferedReader br2 = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("(お茶:code1,コーヒー:code2,ジュース:code3)");

        System.out.print("ドリンクを選んでください。:");

        try {
            // final キーボード入力を受け付ける
            final String inputCode = br2.readLine();
            final Optional<Drink> selectProductOptinal = drinkList.stream().filter(drink -> {
                return inputCode.equals(drink.getCode());
            }).findFirst();

            return selectProductOptinal.get();

        } catch (final IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }

    // 商品購入継続のメソッド
    private static boolean continueBuying() {
        final BufferedReader br3 = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("商品購入を行いますか？行わない場合はお釣りを返却します。YorN :");

        try {
            // final キーボード入力を受け付ける
            final String inputAnswer = br3.readLine();

            boolean IsContinueBuying = false;
            if (inputAnswer.equals("Y")) {
                return IsContinueBuying = true;
            } else {
                return IsContinueBuying = false;
            }
        } catch (final IOException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
    }
}