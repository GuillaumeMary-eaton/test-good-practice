# Good practices around unit test addition

This repo aims at presenting some practices that will help developers to add some test. We can divide those tips in following categories :
- Why should you test your code : see paragraph below for a try to explain why you, as a developer, should add some unit tests
- Identify the impediments that make you not writing tests : this can be very personal, see below for some leads
- Practical use cases : see unit test directory of this repo


# Why should you add unit tests to your code
Testing because someone else asks you to do so is not a good reason to add test, it won't explain why test helps you :
yes, the very first thing is that tests help YOU :
- it avoids regression, so you'll be more confident to add some code to any code base without any complain about your users. If you don't understand what's meant here, think about your PC / smartphone / game upgrade being more unstable than before ;)
- it documents your code by overall adding use-case to it for other developers (which may be you !). By adding input example to your method or class, you'll help your teammates to understand the goal and usage of your method.
- because we forget. Being human means being capable of forgetting which can be an advantage, but it also has some drawbacks : we don't even remember what we did 2 months ago ! So think to "future You", leave him some message in the form of a unit test ;)
- because if you add some test for your new class, you'll ease other developers to add even more tests. Think about why you don't add some test : because non exist ! (may not be the only reason). Though, by not creating tests for you new code, you make other developers not add test...  Break this vicious circle !

# What makes you don't test your code
Here are some leads to let you identify things that make you don't write tests. The idea is to let you find out yours and work on those points by exercising yourself to alleviate those obstacles.
- Creating initial data is too complex (tip : create builders, use @Parameterized tests)
- Creating assertion is too complex (tip : use AssertJ or Truth)
- My test class is messy (tip : use naming convention, use @Nested)
- My new tests has impacts on existing ones (tip : don't share data or test instance between tests)
- Code base has too many dependencies or unmockable ones (tip : refactor tested class)

# Additional words
You may find useful to have a look to some "official" testing methodology such as :
- TDD (Test Driven Development)
- Golden Master
- 