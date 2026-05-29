# Database Setup

로컬 개발 DB는 MySQL 기준입니다.

## 1. MySQL 데이터베이스 생성

`application.yml`의 기본 DB 이름은 `archive`입니다.

```sql
CREATE DATABASE IF NOT EXISTS archive
  DEFAULT CHARACTER SET utf8mb4
  DEFAULT COLLATE utf8mb4_unicode_ci;
```

별도 개발 계정을 사용할 경우:

```sql
CREATE USER IF NOT EXISTS 'archive_user'@'localhost' IDENTIFIED BY 'archive_password';
GRANT ALL PRIVILEGES ON archive.* TO 'archive_user'@'localhost';
FLUSH PRIVILEGES;
```

## 2. 환경변수 설정

Spring Boot는 `.env` 파일을 기본으로 자동 로드하지 않습니다.
실행 환경의 환경변수로 주입하거나 IDE Run Configuration에 등록합니다.

기본값을 그대로 쓰는 경우:

```text
DB_URL=jdbc:mysql://localhost:3306/archive?createDatabaseIfNotExist=true&serverTimezone=Asia/Seoul&characterEncoding=UTF-8
DB_USERNAME=root
DB_PASSWORD=
SERVER_PORT=8080
```

개발 계정을 쓰는 경우:

```text
DB_USERNAME=archive_user
DB_PASSWORD=archive_password
```

## 3. 실행 확인

```bash
./gradlew bootRun
```

정상 연결되면 Hibernate가 시작되며, Entity가 추가된 뒤에는 테이블이 자동 생성됩니다.

현재 JPA 설정:

```yaml
spring.jpa.hibernate.ddl-auto: update
```

개발 중에는 `update`를 사용하고, 배포 전에는 migration 도구나 명시적인 SQL 관리로 전환하는 것을 권장합니다.
