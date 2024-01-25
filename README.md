# Good Pass 서비스
## 개요 
- 클라이밍장 일일이용동의서 작성 서비스
- 기존 클라이밍장에서 종이로 일일이용동의서 작성을 전산화

## 서비스 상세
1. 오픈 서비스로 무료로 사용
2. 서명 기능 제공
3. 클라이밍장 오너 회원 가입 후 QR 발급 (전화 인증 후 바로 발급)
4. 일일이용서 작성 내용 확인 및 통계
5. 완료 페이지 이후에 포스터 등록

[화면 프로토타입 필요]

# 프로젝트 주요 관심사
## git branch 전략
- master branch: 현재 운영 중인 브랜치
- release branch: 출시될 버전을 QA 단계에서 수정하는 브랜치
- hot-fix branch: 현재 출시된 버전에 대한 수정 사항을 관리하는 브랜치
- develop branch: 다음 출시 버전을 준비 중인 브랜치
- feature branch: 다음 출시 버전의 기능 추가를 위한 브랜치

### 새로운 버전 출시 과정
1. feature 브랜치 생성
2. feature 브랜치 기반의 작업 branch 생성
3. feature 브랜치로 작업 브랜치 Pull request
4. feature 브랜치를 develop 브랜치로 merge
5. release branch 생성 후 QA 진행하면서 bugfix
6. release branch를 master와 develop의 merge 후 배포
   
### 버전 출시 이후 hot-fix
1. master 브랜치 대해서 hot-fix 브랜치 생성
2. 기능 수정 후 master 브랜치로 pull request 생성
3. master와 develop에 merge 후에 배포

브랜치 전략 참고자료: https://techblog.woowahan.com/2553/

## package 전략
- domain 중심의 hexagonal 아키텍쳐
   - climbinggym: 클라이밍장 관련 패키지
   - dailypass: 일일이용동의서 관련 패키지
   - exception: GoodPassBusinessException, GoodPassSystemException 두 가지로 분리.
      - GoodPass 프로젝트에서 발생된 예외는 모두 해당 exception으로 감싸서 던지기
   - infra: 인프라 특성이 강한 외부 저장소 및 api 연동 관련 패키지.
      - 결국 domain에 활용되지만 interface를 통하여 해당 패키지에서 외부와 분리하는 작업 수행
- 각 패키지 내에서는 domain, service, controller로 나뉘어 layer 구성. 

## 비지니스 로직 POJO 분리
- ORM을 사용하여 query를 제거하고 맵핑된 객체를 통해 비지니스 로직을 수행하도록 작성
- Controller의 response, request 또는 layer단의 데이터 이동 시에 dto로 분리하여 비지니스 로직을 분리
  - (controller)request -> domainClassCreator (controller와 service를 연결) -> domainClass (business logic)
  - domainClass -> responseDto.of(domainclass) -> (controllert) response
  - request, response 모두 중간에 domainClass를 mapping 해주는 dto가 존재. 해당 dto는 외부와의 연결을 담당. 이를 통해 비지니스 로직 분리.
- repository를 interface를 통해 구현과 분리
  - s3 filestore, database 모두 repository interface와 domain class를 통하여 구현을 완전히 분리

## 테스트
- 통합테스트
   - h2 내장 in-memory 테스트를 활용하여 통합테스트의 운영 서버와 독립하여 테스트 진행
   - 운영 및 개발 환경을 설정 파일과 profile을 활용하여 분리
- 단위테스트
   - 단위테스트 작성을 통한 안정적인 설계
   - repository를 interface로 분리하여 단위 테스트시 stub 객체로 분리
   - controller mock 객체로 감싸서 단위 테스트 진행 (추후에 진행 예정)

## Rest API 설계
- 리소스 중심의 설계
- 재사용성을 고려한 설계

## 로깅 (추후에 추가 예정)

## 성능테스트 (추후에 추가 예정)

# 네트워크 구성 및 서버 구성
![네트워크 구성 및 서버 구성](https://github.com/f-lab-edu/good-pass/assets/75526682/6c02154d-f46e-4865-bf7f-0ba9ccc76518)

## 네트워크 구성
Virtual Private Cloud (VPC) 를 구성하여 독립적인 네트워크를 구축
- public subnet: nginx, jenkins, bastion 서버
   - nginx는 서비스 web server이기 때문에 모든 ip를 open
   - jenkins, bastion 서버는 개발자 ip/port만 open하여 제한적인 사용을 제공
- private subnet: goodpass app과 MySQL server
   - goodpass app과 MySQL server subnet을 분리를 통해 MySQL subnet을 완전히 격리
   - goodpass app subnet은 web server와 연결
   - private server는 오로지 bastion 서버로만 ssh 접근 가능 (bastion 서버와 router table로 연결)

## 서버 구성
- web server (nginx): 초기에는 단순한 web server의 역할. 리버스 프록시를 구성해 app server와 통신. 이후에는 load balancer로 확장 가능
- goodpass app server: goodpass 관련 비지니스 로직을 처리하는 app server
- mysql db server: 테이블 데이터를 관리. app serverd와 통신
- s3 server: 서명 이미지 및 기타 파일을 저장할 수 있는 storage 서버. app server와 통신

# Continuous Integration (CI)
![Continuous Integration](https://github.com/f-lab-edu/good-pass/assets/75526682/bc38f921-4f25-4c8d-bbfd-b357a9abb0d6)

- web hook 트리거 포인트
   - push
   - create pull request
   - merge pull request
  
# Continuous Deployment (CD)
[branch 내용 입력하는 jenkins 스샷 필요]
- jenkins에서 release branch 입력 후 배포
- jenkins에서 app server 접속 후에 pipeline scrypt에 따라 무중단 배포 실행

## 단일 app server로 무중단 배포
![단일 app server로 무중단 배포](https://github.com/f-lab-edu/good-pass/assets/75526682/9ad920d4-8c27-4f02-8b85-9e19b42e32fc)

- traffic이 적은 상태인 초기 단계에서는 하나의 서버로 포트만 달리 두어 blue-green 방식의 배포로 진행
- app 서버를 하나만 두어도 되기 때문에 무중단 서비스를 위해 불필한 비용이 발생하지 않음

## 여러 app server로 무중단 배포 (Rolling)
- 이후 서비스가 커지고 트래픽이 커지는 경우 app 서버를 여러개 두어 rolling 방식으로 배포
