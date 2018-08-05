package main.game


import scala.util.Random

object BaseballGame {
    def main(args: Array[String]): Unit = {

    }

    def convertInputs(input: String): Option[Seq[Int]] = {
        val REGEX = "([0-9])([0-9])([0-9])".r

        input match {
            case REGEX(n1, n2, n3) =>
                if (n1 != n2 && n2 != n3 && n1 != n3)
                    Some(Seq(n1.toInt, n2.toInt, n3.toInt))
                else
                    None
            case _ => None
        }
    }

    def calcBallCount(ballList: Seq[Int], inputList: Seq[Int]): BallCount = {
        var strikes = 0;
        var balls = 0;
        var outs = 0;

        for {
            (ball, indexBall) <- ballList.zipWithIndex;
            (input, indexInput) <- inputList.zipWithIndex
        } {
            if ((ball, indexBall) == (input, indexInput))
                strikes = strikes + 1
            else if (ball == input)
                balls = balls + 1
        }

        BallCount(strikes, balls, outs)
    }

    case class BallCount(strikes: Int, balls: Int, outs: Int)

}
