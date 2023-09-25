class Session:
  def request = "Response"
class Foo:
  private val session: Session^{cap} = new Session
  def withSession[T](f: (local: caps.Cap) ?-> (Session^{local}) => T): T = f(session)

def Test: Unit =
  val f = new Foo
  f.withSession(s => s).request // error
  f.withSession[Session^](t => t) // error
