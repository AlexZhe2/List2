import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public class MessageTask {
    public static void countEachPriority(List<Message> messageList) {
        // TODO:  Подсчитать количество сообщений для каждого приоритела
        //  Ответ в консоль
        int counterLow=0;
        int counterMedium=0;
        int counterHigh=0;
        int counterUrgent=0;
        for (Message i : messageList) {

            if (i.getPriority().equals(MessagePriority.LOW)) {
                counterLow++;
            }
            if (i.getPriority().equals(MessagePriority.MEDIUM)) {
                counterMedium++;
            }
            if (i.getPriority().equals(MessagePriority.HIGH)) {
                counterHigh++;
            }
            if (i.getPriority().equals(MessagePriority.URGENT)) {
                counterUrgent++;
            }
        }
        System.out.println("Количество сообщений для каждого приоритета: LOW="+counterLow+", MEDIUM="+counterMedium+", HIGH="+
                counterHigh+", URGENT="+counterUrgent);
    }

    public static void countEachCode(List<Message> messageList) {
        // TODO: Подсчитать количество сообщений для каждого кода сообщения
        //  Ответ в консоль
        int counter0=0;
        int counter1=0;
        int counter2=0;
        int counter3=0;
        int counter4=0;
        int counter5=0;
        int counter6=0;
        int counter7=0;
        int counter8=0;
        int counter9=0;

        for (Message i : messageList) {

            if (i.getCode()==0) {
                counter0++;
            }
            if (i.getCode()==1) {
                counter1++;
            }
            if (i.getCode()==2) {
                counter2++;
            }
            if (i.getCode()==3) {
                counter3++;
            }
            if (i.getCode()==4) {
                counter4++;
            }
            if (i.getCode()==5) {
                counter5++;
            }
            if (i.getCode()==6) {
                counter6++;
            }
            if (i.getCode()==7) {
                counter7++;
            }
            if (i.getCode()==8) {
                counter8++;
            }
            if (i.getCode()==9) {
                counter9++;
            }
        }
        System.out.println("Количество сообщений для каждого кода сообщения: "+"code#0="+counter0+", code#1="+counter1+
                ", code#2="+counter2+", code#3="+counter3+", code#4="+counter4+", code#5="+counter5+", code#6="+counter6+
                ", code#7="+counter7+", code#8="+counter8+", code#9="+counter9);
    }

    private static void uniqueMessageCount(List<Message> messageList) {
        // TODO: Подсчитать количество уникальных сообщений
        //  Ответ в консоль
        HashSet<Message> messageHashSet = new HashSet<>(messageList);
        System.out.println("Количество уникальных сообщений: "+messageHashSet.size());
    }

    public static List<Message> uniqueMessagesInOriginalOrder(List<Message> messageList) {
        // TODO: вернуть только неповторяющиеся сообщения и в том порядке,
        //  в котором они встретились в первоначальном списке
        //  Например, было: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}, {HIGH, 9}]
        //  на выходе: [{URGENT, 4}, {HIGH, 9}, {LOW, 3}]

        System.out.println("вернуть только неповторяющиеся сообщения и в том порядке в котором они встретились в первоначальном списке");
        System.out.println("Before sorting: "+messageList);

        for (int i = 0; i <messageList.size() ; i++) {

            for (int j = i+1; j <messageList.size() ; j++) {
                if(messageList.get(i).equals(messageList.get(j))){
                    messageList.remove(j);
                }
            }
        }

        System.out.println("After sorting: "+messageList);

        return messageList;
    }

    public static void removeEach(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции каждое сообщение с заданным приоритетом
        //  вывод в консоль до удаления и после удаления
        System.out.println("Удаление из коллекции каждого сообщения с заданным приоритетом: "+priority);
        System.out.println("Before remove "+messageList);
        Iterator<Message> messageIterator = messageList.listIterator();

        while (messageIterator.hasNext()){
            if (messageIterator.next().getPriority().equals(priority)){
                messageIterator.remove();
            }
        }
        System.out.println("After remove "+messageList);
    }

    public static void removeOther(List<Message> messageList, MessagePriority priority) {
        // TODO: удалить из коллекции все сообщения, кроме тех, которые имеют заданный приоритет
        //  вывод в консоль до удаления и после удаления
        System.out.println("Удаление из коллекции сообщений, кроме тех, которые имеют заданный приоритет: "+priority);
        System.out.println("Before remove "+messageList);
        Iterator<Message> messageIterator = messageList.listIterator();

        while (messageIterator.hasNext()){
            if (!messageIterator.next().getPriority().equals(priority)){
                messageIterator.remove();
            }
        }
        System.out.println("After remove "+messageList);
    }

    public static void main(String[] args) {
        // вызов методов
        List<Message> message2 = MessageGenerator.generate(25);

        countEachPriority(message2);
        countEachCode(message2);
        uniqueMessageCount(message2);
        uniqueMessagesInOriginalOrder(message2);
        removeEach(message2, MessagePriority.LOW);
        removeOther(message2, MessagePriority.URGENT);

    }


}