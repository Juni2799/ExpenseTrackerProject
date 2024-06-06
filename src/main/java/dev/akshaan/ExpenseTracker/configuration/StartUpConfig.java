//Class is created only for generating dummy data at application start up to test the API calls
package dev.akshaan.ExpenseTracker.configuration;

import dev.akshaan.ExpenseTracker.models.Expense;
import dev.akshaan.ExpenseTracker.models.Group;
import dev.akshaan.ExpenseTracker.models.User;
import dev.akshaan.ExpenseTracker.models.UserExpense;
import dev.akshaan.ExpenseTracker.models.constants.UserExpenseType;
import dev.akshaan.ExpenseTracker.repository.ExpenseRepository;
import dev.akshaan.ExpenseTracker.repository.GroupRepository;
import dev.akshaan.ExpenseTracker.repository.UserExpenseRepository;
import dev.akshaan.ExpenseTracker.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

@Component
public class StartUpConfig implements CommandLineRunner {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private GroupRepository groupRepository;
    @Autowired
    private ExpenseRepository expenseRepository;
    @Autowired
    private UserExpenseRepository userExpenseRepository;

    @Override
    public void run(String... args) throws Exception {
        //create users
        User johnDoe = new User();
        johnDoe.setName("John Doe");
        johnDoe.setEmail("john.doe@example.com");
        johnDoe.setPassword("password123");
        johnDoe.setGroups(new ArrayList<>());
        johnDoe.setFriends(new ArrayList<>());
        userRepository.save(johnDoe);

        User janeSmith = new User();
        janeSmith.setName("Jane Smith");
        janeSmith.setEmail("jane.smith@example.com");
        janeSmith.setPassword("password456");
        janeSmith.setGroups(new ArrayList<>());
        janeSmith.setFriends(new ArrayList<>());
        userRepository.save(janeSmith);

        User aliceJohnson = new User();
        aliceJohnson.setName("Alice Johnson");
        aliceJohnson.setEmail("alice.johnson@example.com");
        aliceJohnson.setPassword("password789");
        aliceJohnson.setGroups(new ArrayList<>());
        aliceJohnson.setFriends(new ArrayList<>());
        userRepository.save(aliceJohnson);

        User bobBrown = new User();
        bobBrown.setName("Bob Brown");
        bobBrown.setEmail("bob.brown@example.com");
        bobBrown.setPassword("password101");
        bobBrown.setGroups(new ArrayList<>());
        bobBrown.setFriends(new ArrayList<>());
        userRepository.save(bobBrown);

        User charlieDavis = new User();
        charlieDavis.setName("Charlie Davis");
        charlieDavis.setEmail("charlie.davis@example.com");
        charlieDavis.setPassword("password202");
        charlieDavis.setGroups(new ArrayList<>());
        charlieDavis.setFriends(new ArrayList<>());
        userRepository.save(charlieDavis);

        //set friends for users
        List<User> users = userRepository.findAll();
        for(int i=0;i<users.size();i++){
            User i_user = users.get(i);
            List<User> friends = i_user.getFriends();
            for(int j=0;j<users.size();j++){
                User j_user = users.get(j);
                if(!j_user.getName().equals(i_user.getName())){
                    friends.add(j_user);
                }
            }

            i_user.setFriends(friends);
            userRepository.save(i_user);
        }

        //create group and define members
        Group goaTrip = new Group();
        goaTrip.setName("Goa Trip");
        goaTrip.setCreatedBy(johnDoe);
        goaTrip.setCreatedDate(LocalDateTime.now());
        goaTrip.setMembers(new ArrayList<>(userRepository.findAll()));
        goaTrip.setExpenses(new ArrayList<>());
        goaTrip.setTotalAmountSpent(1500);
        groupRepository.save(goaTrip);

        //define expenses
        List<Expense> goaTripExpenseList = goaTrip.getExpenses();

        Expense day1HotelStay = new Expense();
        day1HotelStay.setAddedBy(johnDoe);
        day1HotelStay.setAmount(300);
        day1HotelStay.setDescription("Day1 - Hotel Stay");
        day1HotelStay.setDateOfExpense(LocalDateTime.now());
        day1HotelStay.setCurrency(Currency.getInstance("USD"));
        day1HotelStay.setUserExpenses(new ArrayList<>());

        //johnDoe,janeSmith,aliceJohnson,bobBrown,charlieDavis
        List<UserExpense> day1HotelStayUserExpenses = day1HotelStay.getUserExpenses();
        UserExpense day1HotelStayPaidBy = UserExpense.builder()
                .user(johnDoe).amount(300).userExpenseType(UserExpenseType.PAID).build();
        day1HotelStayUserExpenses.add(day1HotelStayPaidBy);
        userExpenseRepository.save(day1HotelStayPaidBy);

        for(User user: userRepository.findAll()){
            if(!user.getName().equals(day1HotelStayUserExpenses.get(0).getUser().getName())){
                UserExpense day1HotelStayHadToPay = UserExpense.builder()
                        .user(user).amount(60).userExpenseType(UserExpenseType.HAD_TO_PAY).build();
                day1HotelStayUserExpenses.add(day1HotelStayHadToPay);
                userExpenseRepository.save(day1HotelStayHadToPay);
            }
        }

        day1HotelStay.setUserExpenses(day1HotelStayUserExpenses);
        goaTripExpenseList.add(day1HotelStay);
        expenseRepository.save(day1HotelStay);

        //day2 - part 1
        Expense day2MorningWaterActivity = new Expense();
        day2MorningWaterActivity.setAddedBy(bobBrown);
        day2MorningWaterActivity.setAmount(600);
        day2MorningWaterActivity.setDescription("Day2 - Morning Water Activity - Jet Ski");
        day2MorningWaterActivity.setDateOfExpense(LocalDateTime.now().plusDays(1));
        day2MorningWaterActivity.setCurrency(Currency.getInstance("USD"));
        day2MorningWaterActivity.setUserExpenses(new ArrayList<>());

        //johnDoe,janeSmith,aliceJohnson,bobBrown,charlieDavis
        List<UserExpense> day2MorningWaterActivityUserExpense = day2MorningWaterActivity.getUserExpenses();
        UserExpense day2MorningWaterActivityPaidBy = UserExpense.builder()
                .user(bobBrown).amount(600).userExpenseType(UserExpenseType.PAID).build();
        day2MorningWaterActivityUserExpense.add(day2MorningWaterActivityPaidBy);
        userExpenseRepository.save(day2MorningWaterActivityPaidBy);

        for(User user: userRepository.findAll()){
            if(!user.getName().equals(day2MorningWaterActivityUserExpense.get(0).getUser().getName())){
                UserExpense day2MorningWaterActivityHadToPay = UserExpense.builder()
                        .user(user).amount(120).userExpenseType(UserExpenseType.HAD_TO_PAY).build();
                day2MorningWaterActivityUserExpense.add(day2MorningWaterActivityHadToPay);
                userExpenseRepository.save(day2MorningWaterActivityHadToPay);
            }
        }

        day2MorningWaterActivity.setUserExpenses(day2MorningWaterActivityUserExpense);
        goaTripExpenseList.add(day2MorningWaterActivity);
        expenseRepository.save(day2MorningWaterActivity);

        //day2 - part 2
        Expense day2AfternoonWaterActivity = new Expense();
        day2AfternoonWaterActivity.setAddedBy(johnDoe);
        day2AfternoonWaterActivity.setAmount(200);
        day2AfternoonWaterActivity.setDescription("Day2 - Afternoon Water Activity - Scuba Diving");
        day2AfternoonWaterActivity.setDateOfExpense(LocalDateTime.now().plusDays(1));
        day2AfternoonWaterActivity.setCurrency(Currency.getInstance("USD"));
        day2AfternoonWaterActivity.setUserExpenses(new ArrayList<>());

        //johnDoe,janeSmith,aliceJohnson,bobBrown,charlieDavis
        List<UserExpense> day2AfternoonWaterActivityUserExpense = day2AfternoonWaterActivity.getUserExpenses();
        UserExpense day2AfternoonWaterActivityPaidBy = UserExpense.builder()
                .user(johnDoe).amount(200).userExpenseType(UserExpenseType.PAID).build();
        day2AfternoonWaterActivityUserExpense.add(day2AfternoonWaterActivityPaidBy);
        userExpenseRepository.save(day2AfternoonWaterActivityPaidBy);

        UserExpense day2AfternoonWaterActivityHadToPay = UserExpense.builder()
                .user(bobBrown).amount(100).userExpenseType(UserExpenseType.HAD_TO_PAY).build();
        day2AfternoonWaterActivityUserExpense.add(day2AfternoonWaterActivityHadToPay);
        userExpenseRepository.save(day2AfternoonWaterActivityHadToPay);

        day2AfternoonWaterActivity.setUserExpenses(day2AfternoonWaterActivityUserExpense);
        goaTripExpenseList.add(day2AfternoonWaterActivity);
        expenseRepository.save(day2AfternoonWaterActivity);

        //day3
        Expense allThreeDaysFood = new Expense();
        allThreeDaysFood.setAddedBy(aliceJohnson);
        allThreeDaysFood.setAmount(400);
        allThreeDaysFood.setDescription("Food expense - 3 days");
        allThreeDaysFood.setDateOfExpense(LocalDateTime.now().plusDays(2));
        allThreeDaysFood.setCurrency(Currency.getInstance("USD"));
        allThreeDaysFood.setUserExpenses(new ArrayList<>());

        List<UserExpense> allThreeDaysFoodUserExpense = allThreeDaysFood.getUserExpenses();
        UserExpense foodPaidBy = UserExpense.builder()
                .user(aliceJohnson).amount(400).userExpenseType(UserExpenseType.PAID).build();
        allThreeDaysFoodUserExpense.add(foodPaidBy);
        userExpenseRepository.save(foodPaidBy);

        for(User user: userRepository.findAll()){
            if(!user.getName().equals(allThreeDaysFoodUserExpense.get(0).getUser().getName())){
                UserExpense foodHadToPay = UserExpense.builder()
                        .user(user).amount(80).userExpenseType(UserExpenseType.HAD_TO_PAY).build();
                allThreeDaysFoodUserExpense.add(foodHadToPay);
                userExpenseRepository.save(foodHadToPay);
            }
        }

        allThreeDaysFood.setUserExpenses(allThreeDaysFoodUserExpense);
        goaTripExpenseList.add(allThreeDaysFood);
        expenseRepository.save(allThreeDaysFood);

        //set expenses list
        goaTrip.setExpenses(goaTripExpenseList);

        //set group for each user
        for(User user: userRepository.findAll()){
            user.setGroups(List.of(goaTrip));
            userRepository.save(user);
        }

        groupRepository.save(goaTrip);
    }
}
