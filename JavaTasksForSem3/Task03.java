package com.piscenco;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

/**
 * Построить частотный словарь(Map) символов английского или русского алфавита.
 * Для этого взять любой большой кусок текста и сохранить его в файле.
 * Соответственно в коде надо из файла читать.
 */
public class Task03 {

    public static void main(String[] args) {
        Map<String, Integer> frequencies = new HashMap<>();
        StringBuilder text_builder = new StringBuilder();
        try {
            File myObj = new File("E:\\Rita\\JavaProjects\\src\\com\\piscenco\\sample_file.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                text_builder.append(data);
                //System.out.println(data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        String all_text = text_builder.toString();
        String[] all_chars = all_text.split("");
        for(String char_:all_chars){
            int number_of_entries = 0;
            if(char_!= null && !char_.equals("")){
                if (frequencies.containsKey(char_))
                    number_of_entries = frequencies.get(char_)+1;
                frequencies.put(char_, number_of_entries);
            }
        }
        for (String key : frequencies.keySet())
            System.out.println(key + " - " + frequencies.get(key));
        System.out.println();

    }

}
/*
* выводит для приложеннного файла (текст из Приключений Шерлока Хомса на англ и русском ):
А - 2
Б - 1
В - 2
Д - 0
— - 4
Е - 0
Ж - 0
З - 1
И - 2
К - 1
М - 2
Н - 2
О - 8
П - 2
  - 4711
! - 9
" - 163
Т - 2
Х - 4
' - 26
( - 1
Ш - 0
) - 1
, - 269
- - 54
Э - 1
. - 202
Я - 1
а - 225
0 - 0
1 - 3
б - 57
2 - 1
в - 162
3 - 0
г - 71
д - 91
5 - 0
е - 278
ж - 23
з - 44
8 - 7
и - 220
й - 54
: - 2
к - 101
; - 5
л - 150
м - 128
н - 239
о - 362
? - 14
п - 62
р - 121
A - 29
с - 159
B - 20
т - 167
C - 14
у - 82
D - 7
ф - 2
E - 12
х - 29
F - 6
ц - 8
G - 12
ч - 49
H - 49
ш - 13
I - 101
щ - 13
J - 2
ъ - 0
K - 3
ы - 72
L - 6
ь - 38
M - 8
э - 5
N - 7
ю - 19
O - 7
я - 63
P - 9
Q - 1
R - 4
S - 12
T - 34
V - 0
W - 19
Y - 13
a - 989
b - 162
c - 344
d - 493
e - 1458
f - 242
g - 214
h - 703
i - 789
j - 9
k - 90
l - 437
m - 375
n - 802
o - 965
p - 207
q - 8
r - 687
s - 816
t - 1005
u - 383
v - 105
w - 274
x - 19
y - 259
z - 4
« - 1
» - 1
* */