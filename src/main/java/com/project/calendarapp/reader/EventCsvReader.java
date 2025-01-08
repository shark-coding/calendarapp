package com.project.calendarapp.reader;

import com.opencsv.CSVReader;
import com.project.calendarapp.event.Meeting;
import com.project.calendarapp.event.NoDisturbance;
import com.project.calendarapp.event.OutOfOffice;
import com.project.calendarapp.event.Todo;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/*
csv파일의 경로가 제공되었을 때,
그 파일을 읽어서 자바 객체로 바꿔서 반화하는 메서드
 */
public class EventCsvReader {

    private final RawCsvReader rawCsvReader;

    public EventCsvReader(final RawCsvReader rawCsvReader) {
        this.rawCsvReader = rawCsvReader;
    }


    public List<Meeting> readMeetings(String path) throws IOException {
        List<Meeting> result = new ArrayList<>();

        // 데이터를 읽는 부분
        List<String[]> read = rawCsvReader.readAll(path);

        for (int i = 0; i < read.size(); i++) {
            // 첫번째 헤더는 원하는 데이터가 아님 -> 제외시키기
            if (skipHeader(i)){
                continue;
            }

            String[] each = read.get(i);

            // Meeting으로 변환하는 부분
            result.add(
                    new Meeting(
                            Integer.parseInt(each[0]),
                            each[2],
                            ZonedDateTime.of(
                                    LocalDateTime.parse(
                                            each[6],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")
                            ),
                            ZonedDateTime.of(
                                    LocalDateTime.parse(
                                            each[7],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")
                            ),
                            new HashSet<>(Arrays.asList(each[2].split(","))),
                            each[4],
                            each[5]
                    )
            );
        }


        return result;
    }


    public List<Todo> readTodos(String path) throws IOException {
        List<Todo> result = new ArrayList<>();

        // 데이터를 읽는 부분
        List<String[]> read = rawCsvReader.readAll(path);

        for (int i = 0; i < read.size(); i++) {
            // 첫번째 헤더는 원하는 데이터가 아님 -> 제외시키기
            if (skipHeader(i)){
                continue;
            }

            String[] each = read.get(i);

            result.add(
                    new Todo(
                            Integer.parseInt(each[0]),
                            each[2],
                            ZonedDateTime.of(
                                    LocalDateTime.parse(
                                            each[4],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")
                            ),
                            ZonedDateTime.of(
                                    LocalDateTime.parse(
                                            each[5],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")
                            ),
                            each[3]
                    )
            );
        }


        return result;
    }


    public List<NoDisturbance> readNoDisturbances(String path) throws IOException {
        List<NoDisturbance> result = new ArrayList<>();

        // 데이터를 읽는 부분
        List<String[]> read = rawCsvReader.readAll(path);

        for (int i = 0; i < read.size(); i++) {
            // 첫번째 헤더는 원하는 데이터가 아님 -> 제외시키기
            if (skipHeader(i)){
                continue;
            }

            String[] each = read.get(i);

            result.add(
                    new NoDisturbance(
                            Integer.parseInt(each[0]),
                            each[2],
                            ZonedDateTime.of(
                                    LocalDateTime.parse(
                                            each[3],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")
                            ),
                            ZonedDateTime.of(
                                    LocalDateTime.parse(
                                            each[4],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")
                            )
                    )
            );
        }


        return result;
    }


    public List<OutOfOffice> readOutOfOffices(String path) throws IOException {
        List<OutOfOffice> result = new ArrayList<>();

        // 데이터를 읽는 부분
        List<String[]> read = rawCsvReader.readAll(path);

        for (int i = 0; i < read.size(); i++) {
            // 첫번째 헤더는 원하는 데이터가 아님 -> 제외시키기
            if (skipHeader(i)){
                continue;
            }

            String[] each = read.get(i);

            result.add(
                    new OutOfOffice(
                            Integer.parseInt(each[0]),
                            each[2],
                            ZonedDateTime.of(
                                    LocalDateTime.parse(
                                            each[3],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")
                            ),
                            ZonedDateTime.of(
                                    LocalDateTime.parse(
                                            each[4],
                                            DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")
                                    ),
                                    ZoneId.of("Asia/Seoul")
                            )
                    )
            );
        }


        return result;
    }

    private static boolean skipHeader(int i) {
        return i == 0;
    }

//    private List<String[]> readAll(String path) throws IOException {
//        InputStream in = getClass().getResourceAsStream(path);
//        InputStreamReader reader = new InputStreamReader(in, StandardCharsets.UTF_8);
//
//        CSVReader csvReader = new CSVReader(reader);
//        return csvReader.readAll();
//    }
}
