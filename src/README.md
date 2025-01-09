# 일정관리 프로젝트

## 프로젝트 설명
- 구글 캘린더를 참고하여 설계된 Java기반의 일정관리 프로그램
- 일정 추가, 수정, 삭제, 조회 기능을 제공
- opencsv를 사용하여 다건의 데이터 추가 가능
- 콘솔에서 결과를 확인

## 프로젝트 구조
```
project-root
|-- src
|   |-- main
|   |   |-- java
|   |   |   |-- com.project.calendarapp
|   |   |       |-- event
|   |   |       |   |-- update
|   |   |       |   |   |-- AbstractAuditableEvent.java (abstract)
|   |   |       |   |   |-- UpdateMeeting.java
|   |   |       |   |   |-- UpdateNoDisturbance.java
|   |   |       |   |   |-- UpdateOutOfOffice.java
|   |   |       |   |   |-- UpdateTodo.java
|   |   |       |   |-- AbstractEvent.java (abstract)
|   |   |       |   |-- Event.java (interface)
|   |   |       |   |-- EventTypejava (enum)
|   |   |       |   |-- Meeting.java
|   |   |       |   |-- NoDisturbance.java
|   |   |       |   |-- OutOfOffice.java
|   |   |       |   |-- Schedule.java
|   |   |       |   |-- Todo.java
|   |   |       |-- exception
|   |   |       |   |-- InvalidEventException.java
|   |   |       |-- reader
|   |   |       |   |-- EventCsvReader.java
|   |   |       |   |-- RawCsvReader.java
|   |   |       |-- CalendarappApplication
|   |   |-- resources
|   |   |   |-- data
|   |   |       |-- meeting.csv
|   |   |       |-- no_disturbance.csv
|   |   |       |-- out_of_office.csv
|   |   |       |-- to_do.csv
|   |-- test
|   |   |-- java
|   |   |   |-- com.project.calendarapp
|   |   |       |--reader
|   |   |       |   |-- EventCsvReaderTest.java
|-- README.md
```

## 기술 스택
- Java 17
- JUnit
- Mockito
- OpenCSV
- Gradle

## 주요 기능
1. **일정 추가**
    - 일정 시작일과 종료일을 설정.
    - 등록된 일정과 겹치는 경우 등록 불가.
    - OpenCSV를 활용하여 대용량 일정 데이터를 등록 가능.

2. **일정 수정**
    - 삭제된 일정은 수정할 수 없음.

3. **일정 삭제**
    - Soft-delete 방식으로 일정 삭제 관리.

4. **일정 조회**
    - 모든 일정을 조회 가능.

## 주요 도전 과제
1. **단위 테스트와 Mock 활용**
    - 단위 테스트를 처음 시도하며 JUnit 5와 Mockito를 활용해 Mock 데이터로 테스트를 진행.

2. **OpenCSV 적용**
    - OpenCSV 라이브러리를 처음 사용하여 대용량 데이터를 효율적으로 등록하는 로직 구현.

3. **비즈니스 로직 설계**
    - 일정 겹침 검사와 시작일 및 종료일 비교 로직 구현.

## 향후 개선 사항
1. **UI 개선**
    - 콘솔 기반 인터페이스에서 웹 기반 UI로 확장.

2. **알림 기능 추가**
    - 등록된 일정에 대해 알림 기능 구현.

3. **데이터베이스 연동**
    - 현재 메모리 기반으로 관리되며, 데이터베이스 연동으로 데이터의 영속성 확보.