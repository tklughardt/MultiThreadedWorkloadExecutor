# MultiThreadedWorkloadExecutor
Little Java Program to run Workloads through one JDBC driver and probably through multiple database connections. Can be the same database connections though if you modify it.

DISCLAIMER: It is quick & dirty e.g. modifying instance variables from outside instead of using Getters and Setters, that kind of dirty, you get it ;-)
It is only there because I needed to try out something and thought it might be useful. It is not properly tested, there is no nice Exception handling, not even comments but it works. DO NOT use it for any productive use (unless completely overhauling it, then it would be nice if you could share it :-))

If you want to run it, you have to modify the test.csv and add a Snowflake JDBC driver to the classpath. All parameters have to be set in the code directly, because again, it is quick & dirty. I extracted the connections into that test.csv file because it made it easier to do mass execution testing. If you have created enough load, just kill the process.

# The workflow is: 
- Executor uses ReadInputCSV to get the connection parameters from test.csv (hardcoded to my Google drive location on my Mac, you need to change it).
- Executor then stores connection parameters for each line in the CSV file and stores them in an ArrayList.
- Executor creates a ConnectHandle object for each item in the list and connects it to Snowflake.
- Executor spawns a RunWorkloadThread for each connection and passes the ConnectHandle to it.
- RunWorkloadThread generates JSON docs with some randomness (RandomJSONGenerator) to have some userdata.
- RunWorkloadThread inserts the JSON docs into a table in Snowflake.

By default each thread gets an own connection. If you want to share the same connection in multiple threads, you can change the for loop in Executor. I have separated connection creation and the connect in the handle itself.

Have fun and don't expect too much :-)
