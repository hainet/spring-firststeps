# Spting Web `Shift_JIS`

## Spting Web `Shift_JIS` Client

### `Shift_JIS`でリクエストを送信する。
コンテントタイプの設定で、必ず文字コードを指定すること。
```java
HttpHeaders headers = new HttpHeaders();
headers.setContentType(new MediaType(MediaType.APPLICATION_FORM_URLENCODED, Charset.forName("shift_jis")));
```

### `Shift_JIS`でレスポンスを受信する。
```java
CollectionUtils.findValueOfType(
        restTemplate.getMessageConverters(),
        StringHttpMessageConverter.class
).setDefaultCharset(Charset.forName("shift_jis"));
```

### HTTPリクエスト/レスポンスを出力する。
`--debug`オプションを付与して起動することで`RestTemplate`の`DEBUG`ログからHTTPリクエスト/レスポンスの内容を見ることができる。

## Spting Web `Shift_JIS` Server

### `Shift_JIS`でリクエストを受信する。
#### Hints
- `HttpEncodingAutoConfiguration`
- `CharacterEncodingFilter`
- `HttpProperties`
```yml
spring:
  http:
    encoding:
      charset: shift_jis
```

### `Shift_JIS`でレスポンスを送信する。
```java
@PostMapping(value = "", produces = "text/plain;charset=shift_jis")
```
