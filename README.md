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

# 네트워크 구성 및 서버 구성
![네트워크 구성 및 서버 구성](https://github.com/f-lab-edu/good-pass/assets/75526682/6c02154d-f46e-4865-bf7f-0ba9ccc76518)

## 네트워크 구성
Virtual Private Cloud (VPC) 를 구성하여 독립적인 네트워크를 구축
- public subnet: nginx, jenkins, bastion 서버
  - nginx는 서비스 web server이기 때문에 모든 ip를 open
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

# 무중단 배포
## 단일 app server로 무중단 배포
![단일 app server로 무중단 배포](https://github.com/f-lab-edu/good-pass/assets/75526682/9ad920d4-8c27-4f02-8b85-9e19b42e32fc)

- traffic이 적은 상태인 초기 단계에서는 하나의 서버로 포트만 달리 두어 blue-green 방식의 배포로 진행
- app 서버를 하나만 두어도 되기 때문에 무중단 서비스를 위해 불필한 비용이 발생하지 않음

## 여러 app server로 무중단 배포 (Rolling)

- 이후 서비스가 커지고 트래픽이 커지는 경우 app 서버를 여러개 두어 rolling 방식으로 배포

