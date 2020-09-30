class Solution {
    // 本题思路：
    // 先遍历一遍logs，在哈希表存储每个用户访问过的路径列表
    // 遍历每个用户的访问路径列表，得到所有triplet的组合，且无重复的组合
    // 这里同一个用户的同一个visit pattern只算一次,所以还要用HashSet来检验
    // 用哈希表存储每个页面路径列表以及相应出现的次数
    // 得到了所有次数最多的visit pattern，按字典序排序，返回第一个字典序最小的visit pattern
    class Log {
        private String username;
        private int timestamp;
        private String path;
        public Log(String username, int timestamp, String path) {
            this.username = username;
            this.timestamp = timestamp;
            this.path = path;
        }
    }
    public List<String> mostVisitedPattern(String[] username, int[] timestamp, String[] website) {
        // 日志记录的建立
        List<Log> logs = new ArrayList<>();
        for (int i = 0; i < username.length; i++) {
            logs.add(new Log(username[i], timestamp[i], website[i]));
        }
        
        // 根据时间戳排序日志记录
        Collections.sort(logs, (log1, log2) -> {
            return log1.timestamp - log2.timestamp;
        });
        
        // 用哈希表存储每个用户访问过的路径, key为username，value为path的列表，已经根据时间排序好的
        // 举例："joe": ["home", "about", "career"]
        Map<String, List<String>> user_path = new HashMap<>();
        for (Log log: logs) {
            user_path.putIfAbsent(log.username, new ArrayList<String>());
            List<String> path_record = user_path.get(log.username);
            path_record.add(log.path);
            user_path.put(log.username, path_record);
        }
        
        // 存储路径pattern和相应的次数
        Map<List<String>, Integer> pattern_count = new HashMap<>();
        
        // 存储当前出现次数最多的路径pattern，可能有多种pattern
        List<List<String>> max_visited = new ArrayList<>();
        
        int max_count = Integer.MIN_VALUE;
        
        // 遍历每个用户的访问路径列表，得到所有triplet的组合，且无重复的组合
        // 用哈希表存储每个页面路径列表以及相应出现的次数
        for (String user: user_path.keySet()) {
            // 访问过的路径list
            List<String> path_list = user_path.get(user);
            // 以某种次序访问过的路径列表的所有可能的组合模式
            Set<List<String>> visit_pattern = new HashSet<>();
            LinkedList<String> track = new LinkedList<>();
            // 用回溯算法来求得所有可能的组合
            combinations(path_list, visit_pattern, track, 0);
            // 每一个可能的组合加入哈希表，计算每个visit pattern出现的次数
            // 同时更新出现次数最多的visit pattern
            for (List<String> pattern: visit_pattern) {
                int count = pattern_count.getOrDefault(pattern, 0) + 1;
                pattern_count.put(pattern, count);
                if (count > max_count) {
                    max_count = count;
                    max_visited = new ArrayList<List<String>>();
                    max_visited.add(new ArrayList<>(pattern));
                } else if (count == max_count) {
                    max_visited.add(new ArrayList<>(pattern));
                }
            }
        }
        // 得到了所有次数最多的visit pattern，按字典序排序，返回第一个字典序最小的visit pattern
        Collections.sort(max_visited, (triplet1, triplet2) -> {
            if (triplet1.get(0).equals(triplet2.get(0))) {
                if (triplet1.get(1).equals(triplet2.get(1))) {
                    return triplet1.get(2).compareTo(triplet2.get(2));
                } else {
                    return triplet1.get(1).compareTo(triplet2.get(1));
                }
            } else {
                return triplet1.get(0).compareTo(triplet2.get(0));
            }
        });
        return max_visited.get(0);
    }
    // 回溯算法计算出某个用户所有可能的路径组合
    private void combinations(List<String> path_list, Set<List<String>> visit_pattern, LinkedList<String> track, int start) {
        if (track.size() == 3) {
            if (visit_pattern.contains(track)) {
                return;
            } else {
                visit_pattern.add(new ArrayList<>(track));
                return;
            }
        }
        for (int i = start; i < path_list.size(); i++) {
            track.addLast(path_list.get(i));
            combinations(path_list, visit_pattern, track, i + 1);
            track.removeLast();
        }
    }
}