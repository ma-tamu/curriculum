# データべース
  * データベースとは、決まった形式で整理されたデータの集合体のこと。
    ```
    データベースの例
    ・会員情報
    ・電話帳
    ・ショッピングサイトの商品一覧
    ・住所録
    ```
  * データベース管理システム(DBMS)
     * データベースを管理するためのシステムのことを指します。一般的にDBと言われるのはDBMSのことを言っている。
       * DBMSには、Oracle,SQL Server,MySQL,PostgrasSQLといった製品がある。

  * SQL
    * SQLとは、データベース管理されているデータを操作・作成など行うための言語。 SQLには、下記の3つに分類される。
      * データ定義言語 (DDL: data definition language)
        * CREATE,DROP,ALTER
      * データ操作言語 (DML: data manipulation language)
        * INSERT,UPDATE,DELETE,SELECT
      * データ制御言語 (DCL: data control language)
        * GRANT,REVOKE,COMMIT,ROLLBACK...etc

# 演習実施のための環境構築
* 前提dockerがインストールされていること。
* ターミナルでdocker-compose.ymlのあるディレクトに移動して、下記のコマンド実行する。
  ```cmd
  docker-compose up -d
  ```
* mysql-workbench を立ち上げ、sampleデータベースに接続する。

# 演習問題
下記、問のSQLを作成してください。
1. employees から grader が `F` のデータを取得。
2. employees から birth_date が `1960/04/01` 以降のデータを取得。
3. employees から grader が `F` 且つ birth_date が `1960/04/01〜1964/03/31` のデータを取得。
4. employees から grader が `F` 且つ birth_date が `1960/04/01〜1964/03/31` のデータを取得し、 `emp_no` の昇順に並び替えて取得。
5. employees から grader が `M` 且つ birth_date が `1964/12/31` 未満のデータを取得し、`first_name` の昇順、 `hire_date` の降順に並び替えて取得。
6. employees と salaries を結合さて、grader ごとの salary の平均を取得。
7. departments ごとの salary の平均を取得。
8. departments ごとの employees を取得
9. departments に3万以上の employee が所属しているのを取得。
10. employees,departments,title 使って `view` を作成。