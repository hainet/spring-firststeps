# Spting Web `Shift_JIS`

## Spting Web `Shift_JIS` Client

### `Shift_JIS` でリクエストを送信する。
コンテントタイプの設定で、必ず文字コードを指定すること。
```java
HttpHeaders headers = new HttpHeaders();
headers.setContentType(new MediaType(MediaType.APPLICATION_FORM_URLENCODED, Charset.forName("shift_jis")));
```

### `Shift_JIS` でレスポンスを受信する。
```java
@Bean
public CommandLineRunner configureDefaultCharset(final List<HttpMessageConverter<?>> converters) {
    return args -> {
        final StringHttpMessageConverter converter = CollectionUtils.findValueOfType(
                converters,
                StringHttpMessageConverter.class
        );

        if (converter != null) {
            converter.setDefaultCharset(Charset.forName("Shift-JIS"));
        }
    };
}
```

### HTTPリクエスト/レスポンス情報を出力する。
```yml
logging:
  level:
    org.springframework.web.client.RestTemplate: DEBUG
```

## Spting Web `Shift_JIS` Server

### `Shift_JIS` でリクエストを受信する。
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

### `Shift_JIS` でレスポンスを送信する。
```java
@PostMapping(value = "", produces = "text/plain;charset=shift_jis")
```

または

```java
@Bean
public CommandLineRunner configureDefaultCharset(final List<HttpMessageConverter<?>> converters) {
    return args -> {
        final StringHttpMessageConverter converter = CollectionUtils.findValueOfType(
                converters,
                StringHttpMessageConverter.class
        );

        if (converter != null) {
            converter.setDefaultCharset(Charset.forName("Shift-JIS"));
        }
    };
}
```
