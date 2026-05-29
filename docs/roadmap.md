# Archive Backend Roadmap

Spring Boot + Thymeleaf + DB 기반 개인 개발 블로그 구현 우선순위입니다.
Astro 프로젝트는 디자인과 화면 구조 참고용으로 사용합니다.

## 1. 프로젝트 실행 환경 정리

- Java 설치 확인
- `JAVA_HOME` 설정
- Gradle build/test 성공 확인

## 2. DB 선택 및 연결

- MySQL 실행
- `application.yml` 설정
- JPA `ddl-auto` 설정
- DB 연결 테스트

## 3. 도메인 모델 설계

MVP 기준 엔티티:

- `User`
- `Article`
- `Project`
- `Category`
- `Tag`
- `ArticleTag`

초기 범위에서는 댓글, 좋아요, 이미지 테이블은 제외합니다.

## 4. Article CRUD 구현

- `Article` Entity
- `ArticleRepository`
- `ArticleService`
- `ArticleController`
- 글 목록
- 글 상세
- 관리자 글 작성
- 관리자 글 수정
- 관리자 글 삭제

## 5. Markdown 렌더링

- DB에는 Markdown 원문 저장
- 화면 출력 시 Markdown을 HTML로 변환
- Thymeleaf에서 `th:utext`로 출력
- XSS 처리 방식 검토

## 6. Project CRUD 구현

- `Project` Entity
- 프로젝트 목록
- 프로젝트 상세
- 관리자 프로젝트 작성
- 관리자 프로젝트 수정
- 관리자 프로젝트 삭제

## 7. Category / Tag 기능

- 카테고리별 글 목록
- 태그별 글 목록
- `Article` - `Tag` 다대다 매핑

## 8. 관리자 인증

- Spring Security 적용
- 로그인
- 로그아웃
- `/admin/**` 접근 보호
- 관리자 계정 seed 데이터 구성

## 9. Astro 화면 Thymeleaf 이식

- `BaseLayout.astro` -> `fragments/layout`
- `Navbar.astro` -> `fragments/navbar`
- `Footer.astro` -> `fragments/footer`
- `index.astro` -> `index.html`
- `articles/index.astro` -> `articles/list.html`
- `articles/[slug].astro` -> `articles/detail.html`
- `project.astro` -> `projects/list.html`
- `project/[slug].astro` -> `projects/detail.html`
- `about.astro` -> `about.html`

## 10. 검색 / 조회수 / 상태값 추가

- 제목/본문 검색
- 공개/비공개
- 임시저장
- 조회수
- 최신글
- 추천글

## 11. 테스트 코드

- `ArticleServiceTest`
- `ProjectServiceTest`
- Repository 테스트
- Controller slice 테스트

## 12. 배포

- `Dockerfile`
- `docker-compose.yml`
- MySQL + Spring Boot 배포
- 환경변수 분리
- README 작성

## Next Step

1. `JAVA_HOME` 해결
2. `application.yml` 생성
3. MySQL 연결
4. `Article` Entity 작성
