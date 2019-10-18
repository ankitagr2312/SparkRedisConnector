import org.apache.spark.sql.SparkSession
import com.redislabs.provider.redis._

object RedisReaderBatch {
  def main(args: Array[String]): Unit = {

    val arrayOfKeys = Array("ank", "ankit")
    val spark = SparkSession
      .builder()
      .appName("RedisReader")
      .master("local[*]")
      .config("spark.redis.host", "localhost")
      .config("spark.redis.port", "6379")
      .getOrCreate()

    val sc = spark.sparkContext
    val keysRDD = sc.fromRedisKeys(arrayOfKeys, 5)
    keysRDD.getKV().collect().foreach(println)

  }
}
