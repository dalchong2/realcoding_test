import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import static org.hamcrest.collection.IsEmptyCollection.empty;
import static org.hamcrest.CoreMatchers.notNullValue;



public class ChampionTest {
    private List<Champion> championList = new ArrayList<Champion>();

    @Before
    public void setUp() {

        //5개의 챔피언 객체를 만듭니다.
        //Champion topChamp = new Champion("다리우스", "탑");
        //Champion jungleChamp = new Champion("리신", "정글");
        //Champion midChamp = new Champion("르블랑", "미드");
        //Champion adcChamp = new Champion("베인", "바텀");
        //Champion supportChamp = new Champion("레오나", "바텀");

        //앞서 만든 List 에 각 챔피언을 추가합니다.
        //championList.add(topChamp);
        //championList.add(jungleChamp);
        //championList.add(midChamp);
        //championList.add(adcChamp);
        //championList.add(supportChamp);

        //전체 멤버는 12명이지만 포지션이 겹치는 멤버는 제외
        Champion  leader = new Champion("권은비", "리더");
        Champion  supVocal= new Champion("사쿠라", "서브보컬");
        Champion  leadLapper = new Champion("강혜원", "리드래퍼");
        Champion  lapper = new Champion("최예나", "래퍼");
        Champion  mainDancer = new Champion("이채연", "메인댄서");
        Champion  leadVocal= new Champion("김채원", "리드보컬");
        Champion  mainVocal = new Champion("조유리", "메인보컬");
        Champion  leadDancer = new Champion("안유진", "리드댄서");
        Champion  center = new Champion("장원영", "센터");

        championList.add(leader);
        championList.add(supVocal);
        championList.add(leadLapper);
        championList.add(lapper);
        championList.add(mainDancer);
        championList.add(leadVocal);
        championList.add(mainVocal);
        championList.add(leadDancer);
        championList.add(center);

    }

    //List<String>을 생성하고 값이 비어 있는지를 테스트 empty()
    @Test
    public void givenCollectionWhenEmptyCorrect() {
        List<String> emptyList = new ArrayList<>();
        assertThat(emptyList, empty());
    }

    //notNullValue 활용한 테스트
    @Test
    public void notNullCheck() {
        //String lck = "LCK";
        String IZone = "IZone";
        //assertThat(lck, notNullValue());
        assertThat(IZone, notNullValue());
    }

    //nullValue 활용한 테스트
    @Test
    public void givenStringWhenNullIsCorrect() {
        String lck = null;
        assertThat(lck, nullValue());
        assertThat(lck, notNullValue());//오류가 발생한다.


    }


    //문자열 관련 테스트 anyOf, containsString, endWith
    @Test
    public void testForRelatedString() {
        String sampleString1 = "Player Focus";
        String sampleString2 = "Player point";
        String sampleSrting3 = "Focus Player point ";
        String startString = "Player";
        String startString2 = "Focus";
        String endString = "point";
        assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString)));
        assertThat(sampleSrting3,anyOf(startsWith(startString2),containsString(startString)));
        assertThat(sampleString1, allOf(startsWith(startString),endsWith(startString2)));
        //assertThat(sampleString1, is(endsWith(endString)));
        assertThat(sampleString2, is(startsWith(startString)));
        assertThat(sampleString2, is(endsWith(endString)));

        //assertThat(sampleString1, anyOf(startsWith(startString), containsString(endString)));
        //assertThat(sampleString2, is(endsWith(endString)));
    }

    //부동소수점 범위 closeTo 테스트
    @Test
    public void testForFloatingPoint() {
        //assertThat(3.14, closeTo(3, 0.2));
        assertThat(4.2, closeTo(4, 0.7));//이부분 강사님께 질문
    }

    //anything 테스트
    @Test
    public void shouldNotErrorGetReference() {
        assertThat(championList.get(0), anything());
        assertThat(championList.get(10),anything());
        System.out.println(championList.get(0));
    }

    //객체 크기 검증 테스트 hasSize
    @Test
    public void shouldChampionCountFive() {
        //assertTrue(championList.size() == 5);
        //assertThat(championList.size(), is(5));
        //assertThat(championList, hasSize(5));

        assertTrue(championList.size() == 9);
        assertFalse(championList.size()==8);
        assertThat(championList.size(), is(9));
        assertThat(championList, hasSize(10));
    }

    //서폿 챔피언은 타릭이어야 한다라는 조건으로 테스트 코드 작성
    @Test
    public void shouldSupportChampionIsTaric() {
        Champion supportChamp = new Champion("타릭", "바텀");
//        assertThat("타릭", is(supportChamp.getName()));
//        assertThat("타릭", is(equalTo(supportChamp.getName())));
//        assertThat("타릭", equalTo(supportChamp.getName()));
    }

    //hasProperty 활용하여 속성이 포함되어 있는지 테스트
    @Test
    public void shouldHasPropertyPosition() {
//        assertThat(championList.get(0), hasProperty("position"));
//        assertThat(championList.get(0), hasProperty("position", equalTo("탑")));
    }

    //hasToString 활용 테스트
    @Test
    public void shouldHaveSomeChampName() {
        List<String> champListNames = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가느", "블라디미르");
        assertThat(champListNames.get(0), hasToString("루시안"));
        assertThat(champListNames.get(0), hasToString("애"));

    }

    //property와 value가 같은지 테스트
    @Test
    public void shouldHaveSamePropertyAndValue() {
        List<String> championNames1 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        List<String> championNames2 = Arrays.asList("루시안", "애쉬", "렉사이", "갈리오", "모르가나", "블라디미르");
        assertThat(championNames1, samePropertyValuesAs(championNames2));
//        assertThat(championNames1, samePropertyValuesAs(championNames2));
    }

    //탑 챔피언은 다리우스여야 한다라는 조건으로 테스트 코드 작성, stream 활용예
    @Test
    public void shouldTopChampionIsDarius() {
        Optional<Champion> filterdChampion = championList.stream()
                .filter(c -> c.getPosition().equals("탑"))
                .findFirst();
        String champName = filterdChampion.get().getName();
        assertTrue(champName.equals("다리우스"));
        assertThat("다리우스", is(champName));
    }

}