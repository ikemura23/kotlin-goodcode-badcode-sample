# kotlin-goodcode-badcode-sample

以下の本を読み、紹介例をKotlinで書いてみる自己学習用のRepository

良いコード／悪いコードで学ぶ設計入門―保守しやすい　成長し続けるコードの書き方   仙塲 大也  
https://www.amazon.co.jp/dp/B09Y1MWK9N

## デメテルの法則
利用するオブジェクトの内部を知るべきではない、とするもので、「知らない人に話しかけるな」と要約されたりもする。

## 尋ねるな、命じろ（Tell,Don'tAsk.）

ほかのオブジェクトの内部情報（変数）を尋ねたり、その状態に応じて呼び出し側を判断したりするのではなく、呼び出し側はただメソッドで命ずるだけで、命令された側で適切な制御は判断をするよう設計する。

- インスタンス変数をprivateにして外部からアクセスできないようにする
- インスタンス変数に対する制御は、メソッドとして外部から命ずる形にする
- 命令された側が、詳細な判断や制御を担う作りにする

