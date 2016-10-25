package cr.tec.rest;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 * Created by joseph on 10/24/16.
 */
@Path( "/hello" )
public class Hello
{
	public Hello( ) {}

	@GET
	@Produces( "text/html" )
	public String printHelloWorld( )
	{
		return "Hello World";
	}
}