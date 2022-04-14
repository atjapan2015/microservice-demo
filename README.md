# microservice-demo

### Build
```aidl
./mvnw clean package
```

```aidl
docker build -t YOUR_TAG .
```

```aidl
docker pull YOUR_TAG
```

### deploy

```aidl
kubectl apply -f deploy/
```

### access

```aidl
curl YOUR_IP:8081/http
curl YOUR_IP:8081/grpc
```

### use http2

```aidl
openssl req -x509 -out mylocalserver.com.crt -keyout mylocalserver.com.key \
  -newkey rsa:4096 -nodes -sha256 \
  -subj '/CN=mylocalserver' -extensions EXT -config <( \
   printf "[dn]\nCN=mylocalserver\n[req]\ndistinguished_name = dn\n[EXT]\nsubjectAltName=DNS:mylocalserver.com\nkeyUsage=digitalSignature\nextendedKeyUsage=serverAuth")
openssl pkcs12 -export -in mylocalserver.com.crt -inkey mylocalserver.com.key -name mylocalserver.com -out mylocalserver.com.p12
# Password
```