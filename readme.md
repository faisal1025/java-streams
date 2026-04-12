# 📌 BASE INPUT (use this everywhere)


```java
List<String> data = List.of(
"java spring boot",
"microservices docker kubernetes",
"aws azure gcp",
"java docker aws"
);
```

# 🟢 LEVEL 1 – BASIC SPLIT & FLATTEN

**1.** Split each string by space and collect all words into a single List<String>

**2.** Print each word on a new line using Stream

**3.** Convert all words to uppercase

**4.** Count total number of words

**5.** Get distinct words only

# 🟡 LEVEL 2 – FILTERING AFTER SPLIT

**6.** Find words that start with "a"

**7.** Find words with length > 5

**8.** Exclude words containing letter "o"

**9.** Get only words ending with "s"

**10.** Filter words that contain "java"

# 🟠 LEVEL 3 – SORTING & LIMITING

**11.** Sort all words alphabetically

**12.** Sort words by length (ascending)
```java
.sorted(Comparator.comparing(String::length))
// OR using comparingInt for primitive int
.sorted(Comparator.comparingInt(String::length))
```

**13.** Sort words by length (descending)
```java
.sorted(Comparator.comparing(String::length).reversed())
// OR
.sorted((a, b) -> Integer.compare(b.length(), a.length()))
```

**14.** Get top 5 longest words

**15.** Skip first 3 words and print remaining

# 🔵 LEVEL 4 – DUPLICATES & FREQUENCY (INTERVIEW GOLD)

**16.** Find duplicate words

**17.** Count frequency of each word

**18.** Find word with highest frequency

**19.** Find word with lowest frequency

**20.** Print words that appear more than once

# 🟣 LEVEL 5 – ADVANCED STRING LOGIC

**21.** Find words containing only vowels

**22.** Find words containing both 'a' and 's'

**23.** Find palindromic words

**24.** Find longest word

**25.** Find shortest word

# 🔴 LEVEL 6 – MAP + COLLECTORS

**26.** Group words by their length

**27.** Group words by first character

**28.** Map word → word length

**29.** Partition words by length > 5

**30.** Create Map<Integer, List<String>> (length → words)

# ⚡ LEVEL 7 – REDUCE & CUSTOM LOGIC

**31.** Concatenate all words into a single string

**32.** Find total character count (excluding spaces)

**33.** Find longest word using reduce()

**34.** Find lexicographically largest word

**35.** Find lexicographically smallest word

# 🧠 LEVEL 8 – REAL INTERVIEW STYLE QUESTIONS

**36.** Find first repeated word

**37.** Find first non-repeated word

**38.** Check if all words are unique

**39.** Check if any word length > 10

**40.** Count words per sentence

# 💀 LEVEL 9 – TRICKY VARIANTS (EXPECT THESE)
```java
// Input change:
List<String> data = List.of(
    "java,spring,boot",
    "docker|kubernetes", 
    "aws;azure;gcp"
);
```

**41.** Split using multiple delimiters
```java
.flatMap(str -> Arrays.stream(str.split("[,|;]")))
```

**42.** Collect all words into a Set

**43.** Normalize words to lowercase before processing

**44.** Remove empty strings after split

**45.** Handle null or blank strings safely

# 🏁 FINAL BOSS ROUND (LIVE CODING FEEL)

**46.** Return top 3 most frequent words

**47.** Return longest word from each sentence

**48.** Sentence with maximum number of words

**49.** Sort sentences by number of words

**50.** Convert output to Map<String, Long> (word → count)

---

## 🎯 STREAM API INTERVIEW CHEAT SHEET

### **Must Remember Pipeline:**
```
Collection.stream() → filter/map/sorted → collect/forEach/reduce
```

### **Common Patterns:**
1. **Split & Flatten:** `flatMap(str -> Arrays.stream(str.split(" ")))`
2. **Count Frequency:** `groupingBy(identity(), counting())`
3. **Find Duplicates:** `groupingBy(identity(), counting()).entrySet().stream().filter(e -> e.getValue() > 1)`
4. **Top N:** `sorted(comparator).limit(n)`
5. **Group by Property:** `groupingBy(Object::property)`

### **Performance Tips:**
- Use `parallelStream()` for large datasets
- `findFirst()` is faster than `collect().get(0)`
- `anyMatch()` is faster than `filter().count() > 0`
- Chain operations efficiently: filter before map

### **Common Mistakes to Avoid:**
- Forgetting terminal operation (stream won't execute)
- Using stream twice (IllegalStateException)
- Not handling Optional returned by findFirst/findAny
- Modifying original collection during stream processing

# Java Stream API 8 - Complete Guide 🚀

## 📝 What is Stream API?

**Stream** is a sequence of elements supporting sequential and parallel aggregate operations. It's NOT a data structure but a way to process collections declaratively.

### Key Characteristics:
- **Functional Programming**: Uses lambda expressions and method references
- **Lazy Evaluation**: Intermediate operations are not executed until terminal operation is called
- **Pipeline**: Chain of operations (intermediate → terminal)
- **No Storage**: Streams don't store data, they process it
- **Immutable**: Original collection remains unchanged

### Stream Pipeline:
```
Collection → Stream → Intermediate Operations → Terminal Operation → Result
```

---

## 🔧 INTERMEDIATE OPERATIONS (Lazy - Return Stream)

### 1. **filter(Predicate<T>)** - Filters elements based on condition
```java
// Example: Filter words starting with "a"
stream.filter(word -> word.startsWith("a"))
```

### 2. **map(Function<T,R>)** - Transforms each element
```java
// Example: Convert to uppercase
stream.map(String::toUpperCase)
// Example: Get word lengths
stream.map(String::length)
```

### 3. **flatMap(Function<T,Stream<R>>)** - Flattens nested structures
```java
// Example: Split strings and flatten to single stream
stream.flatMap(str -> Arrays.stream(str.split(" ")))
```

### 4. **distinct()** - Removes duplicates
```java
stream.distinct()
```

### 5. **sorted()** - Sorts elements (natural order)
```java
stream.sorted()
// With custom comparator
stream.sorted(Comparator.comparing(String::length))
stream.sorted(Comparator.comparing(String::length).reversed())
```

### 6. **limit(long)** - Limits stream to first n elements
```java
stream.limit(5)  // Get first 5 elements
```

### 7. **skip(long)** - Skips first n elements
```java
stream.skip(3)   // Skip first 3 elements
```

### 8. **peek(Consumer<T>)** - Performs action without modifying stream (debugging)
```java
stream.peek(System.out::println)
```

---

## 🎯 TERMINAL OPERATIONS (Eager - Return Result)

### 1. **collect(Collector)** - Collects elements into collections/maps
```java
// To List
.collect(Collectors.toList())
// To Set
.collect(Collectors.toSet())
// To Map (word -> length)
.collect(Collectors.toMap(Function.identity(), String::length))
// Group by length
.collect(Collectors.groupingBy(String::length))
// Partition by condition
.collect(Collectors.partitioningBy(word -> word.length() > 5))
// Counting frequency
.collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
```

### 2. **forEach(Consumer<T>)** - Performs action on each element
```java
stream.forEach(System.out::println)
stream.forEach(word -> System.out.println(word.toUpperCase()))
```

### 3. **reduce(BinaryOperator<T>)** - Reduces stream to single value
```java
// Concatenate all strings
.reduce("", (a, b) -> a + " " + b)
// Find longest word
.reduce((a, b) -> a.length() > b.length() ? a : b)
```

### 4. **count()** - Returns count of elements
```java
long count = stream.count();
```

### 5. **anyMatch(Predicate<T>)** - Checks if any element matches
```java
boolean hasLongWord = stream.anyMatch(word -> word.length() > 10);
```

### 6. **allMatch(Predicate<T>)** - Checks if all elements match
```java
boolean allUnique = stream.allMatch(word -> Collections.frequency(list, word) == 1);
```

### 7. **noneMatch(Predicate<T>)** - Checks if no elements match
```java
boolean noDuplicates = stream.noneMatch(word -> Collections.frequency(list, word) > 1);
```

### 8. **findFirst()** - Returns first element (Optional)
```java
Optional<String> first = stream.findFirst();
```

### 9. **findAny()** - Returns any element (Optional)
```java
Optional<String> any = stream.findAny();
```

### 10. **min/max(Comparator<T>)** - Returns min/max element
```java
Optional<String> shortest = stream.min(Comparator.comparing(String::length));
Optional<String> longest = stream.max(Comparator.comparing(String::length));
```

---

## 📌 IMPORTANT INTERVIEW CONCEPTS

### **Method References:**
- `String::length` ≡ `str -> str.length()`
- `System.out::println` ≡ `str -> System.out.println(str)`
- `String::toUpperCase` ≡ `str -> str.toUpperCase()`

### **Comparator Usage:**
```java
// Ascending by length
.sorted(Comparator.comparing(String::length))
// Descending by length  
.sorted(Comparator.comparing(String::length).reversed())
// Multiple criteria
.sorted(Comparator.comparing(String::length).thenComparing(String::compareTo))
```

### **compareTo() Method:**
- Returns **negative** if `this` is lexicographically before `other`
- Returns **zero** if they are equal
- Returns **positive** if `this` is lexicographically after `other`
- Works with String, Integer, and all Comparable types

### **comparingInt() vs comparing() for Primitive Types:**
```java
// For primitive int values - MORE EFFICIENT
.sorted(Comparator.comparingInt(String::length))

// For Object wrapper types - creates Integer objects
.sorted(Comparator.comparing(String::length))

// Other primitive comparators available:
.sorted(Comparator.comparingLong(obj -> obj.getLongValue()))
.sorted(Comparator.comparingDouble(obj -> obj.getDoubleValue()))

// Descending order with comparingInt
.sorted(Comparator.comparingInt(String::length).reversed())

// Multiple criteria with comparingInt
.sorted(Comparator.comparingInt(String::length)
         .thenComparing(String::compareTo))
```

**Why use comparingInt()?**
- **Performance**: Avoids boxing/unboxing of primitive int to Integer
- **Memory**: No temporary Integer objects created
- **Cleaner**: Specifically designed for primitive int comparisons

### **collect() Always Takes Collector:**
Yes, `collect()` always requires a Collector. Common ones:
- `Collectors.toList()`
- `Collectors.toSet()`
- `Collectors.groupingBy()`
- `Collectors.counting()`

### **map() Return Type:**
Whatever you return from `map()` becomes the new stream element type.
```java
Stream<String> -> map(String::length) -> Stream<Integer>
```

---

