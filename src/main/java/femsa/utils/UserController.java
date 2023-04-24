package femsa.utils;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import femsa.models.User;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

    public class UserController {
        private HashMap<String, User> userMap;

        public UserController() {
            userMap = new HashMap<>();
        }

        public void addUser(String key, User user) {
            userMap.put(key, user);
        }

        public User getUserByKey(String key) {
            return userMap.get(key);
        }

        public void loadUsersFromJson(String json) {
            Gson gson = new Gson();
            Type type = new TypeToken<HashMap<String, User>>() {}.getType();
            HashMap<String, User> userMap = gson.fromJson(json, type);

            for (Map.Entry<String, User> entry : userMap.entrySet()) {
                addUser(entry.getKey(), entry.getValue());
            }
        }

    }
