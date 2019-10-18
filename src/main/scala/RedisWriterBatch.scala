import org.apache.spark.sql.SparkSession

class RedisWriterBatch {
  def main(args: Array[String]): Unit = {

    val spark = SparkSession
      .builder()
      .appName("RedisWriter")
      .master("local[*]")
      .config("spark.redis.host", "localhost")
      .config("spark.redis.port", "6379")
      .getOrCreate()
    val personSeq = Seq(Person("John", 30), Person("Peter", 45))
    val df = spark.createDataFrame(personSeq)

    df.write
      .format("org.apache.spark.sql.redis")
      .option("table", "person")
      .save()
  }
  case class Person(name: String, age: Int)
}
