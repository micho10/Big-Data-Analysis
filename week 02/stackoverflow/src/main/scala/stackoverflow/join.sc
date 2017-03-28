import stackoverflow.Posting

val input = Array(
  "1,27233496,,,0,C#",
  "1,23698767,,,9,C#",
  "1,5484340,,,0,C#",
  "2,5494879,,5484340,1,",
  "1,9419744,,,2,Objective-C",
  "1,26875732,,,1,C#",
  "1,9002525,,,2,C++",
  "2,9003401,,9002525,4,",
  "2,9003942,,9002525,1,",
  "2,9005311,,9002525,0"
)


def rawPostings(lines: Array[String]): Array[Posting] =
  lines.map(line => {
    val arr = line.split(",")
    Posting(postingType =    arr(0).toInt,
      id =             arr(1).toInt,
      acceptedAnswer = if (arr(2) == "") None else Some(arr(2).toInt),
      parentId =       if (arr(3) == "") None else Some(arr(3).toInt),
      score =          arr(4).toInt,
      tags =           if (arr.length >= 6) Some(arr(5).intern()) else None)
  })

//def groupedPostings(postings: Array[Posting]): Array[(Int, Iterable[(Posting, Posting)])] = {
//  val questions = postings.filter(posting => posting.postingType == 1)
//  val answers = postings.filter(posting => posting.postingType == 2)
//}

val postings = rawPostings(input)

val questions = postings.filter(_.postingType == 1)
                .map(p => (p.id, p))

val answers = postings.filter(_.postingType == 2)
  .map(p => (p.parentId.get, p))


//              .map(p match {case Some(id) => (p.parentId, p)})

/*

 */