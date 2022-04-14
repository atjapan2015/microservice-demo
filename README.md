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