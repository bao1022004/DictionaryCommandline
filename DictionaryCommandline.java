+package Dictionary;
import org.w3c.dom.ls.LSOutput;

import java.util.Collections;
import java.util.Comparator;
import java.util.Dictionary;
import java.util.Scanner;

public class DictionaryCommandline {
    public void showAllWords(Dictionary dictionary){
        // sắp xếp các từ theo alphabet
        Collections.sort(dictionary.getWords(), new Comparator<Word>()) {
            public int compare(Word no1, Word no2) {
                return no1.getEnglish().compareTo(no2.getEnglish());
            }
        };
        System.out.println("No | English | Vietnamese");
        for(int i = 0; i < dictionary.getWords().size(); i++) {
            Word word = dictionary.getWords().get(i);
            System.out.println((i+1) + " | " + word.getEnglish() + " | " + word.getVietnamese());
        }
    }

    public void insertFromCommandline(Dictionary dictionary) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập số lượng từ vựng muốn thêm: ");
        int n = sc.nextInt();
        sc.nextLine();
        for(int i = 0; i < n ;i ++) {
            System.out.println("Nhập từ vựng tiếng anh: ");
            String english = sc.nextLine();
            System.out.println("Nhập nghĩa tiếng việt: ");
            String vietnamese = sc.nextLine();
            Word word = new Word(english, vietnamese); //tạo đối tượng word
            dictionary.addWord(word); // thêm word vào dictionary
        }
    }
    public void dictionaryBasic(Dictionary dictionary) {
        insertFromCommandline(dictionary); // nhập dữ liệu từ vựng
        showAllWords(dictionary); // in danh sách từ vựng theo alphabet
    }
}
