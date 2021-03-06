// Skeleton class generated by rmic, do not edit.
// Contents subject to change without notice.

package wm;

public final class WumpusMonitor_Skel
    implements java.rmi.server.Skeleton
{
    private static final java.rmi.server.Operation[] operations = {
	new java.rmi.server.Operation("void currentWorld(ws.WumpusWorld)"),
	new java.rmi.server.Operation("void gameOver()"),
	new java.rmi.server.Operation("void grab(ws.Agent)"),
	new java.rmi.server.Operation("void join(ws.Agent)"),
	new java.rmi.server.Operation("void killed(ws.Agent)"),
	new java.rmi.server.Operation("void leave(ws.Agent)"),
	new java.rmi.server.Operation("void shoot(ws.Agent)"),
	new java.rmi.server.Operation("void turnLeft(ws.Agent)"),
	new java.rmi.server.Operation("void turnRight(ws.Agent)"),
	new java.rmi.server.Operation("void walk(ws.Agent)")
    };
    
    private static final long interfaceHash = 6981510301184247140L;
    
    public java.rmi.server.Operation[] getOperations() {
	return (java.rmi.server.Operation[]) operations.clone();
    }
    
    public void dispatch(java.rmi.Remote obj, java.rmi.server.RemoteCall call, int opnum, long hash)
	throws java.lang.Exception
    {
	if (opnum < 0) {
	    if (hash == -9149345874680416345L) {
		opnum = 0;
	    } else if (hash == 5736731529201808777L) {
		opnum = 1;
	    } else if (hash == -8014957209125394315L) {
		opnum = 2;
	    } else if (hash == 1521140894510410881L) {
		opnum = 3;
	    } else if (hash == 5649366933779381790L) {
		opnum = 4;
	    } else if (hash == -3097638429081310540L) {
		opnum = 5;
	    } else if (hash == -2675756012212764232L) {
		opnum = 6;
	    } else if (hash == -75264505647420283L) {
		opnum = 7;
	    } else if (hash == -5887424182645229933L) {
		opnum = 8;
	    } else if (hash == -5426102191795581649L) {
		opnum = 9;
	    } else {
		throw new java.rmi.UnmarshalException("invalid method hash");
	    }
	} else {
	    if (hash != interfaceHash)
		throw new java.rmi.server.SkeletonMismatchException("interface hash mismatch");
	}
	
	wm.WumpusMonitor server = (wm.WumpusMonitor) obj;
	switch (opnum) {
	case 0: // currentWorld(WumpusWorld)
	{
	    ws.WumpusWorld $param_WumpusWorld_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_WumpusWorld_1 = (ws.WumpusWorld) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.currentWorld($param_WumpusWorld_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 1: // gameOver()
	{
	    call.releaseInputStream();
	    server.gameOver();
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 2: // grab(Agent)
	{
	    ws.Agent $param_Agent_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_Agent_1 = (ws.Agent) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.grab($param_Agent_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 3: // join(Agent)
	{
	    ws.Agent $param_Agent_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_Agent_1 = (ws.Agent) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.join($param_Agent_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 4: // killed(Agent)
	{
	    ws.Agent $param_Agent_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_Agent_1 = (ws.Agent) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.killed($param_Agent_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 5: // leave(Agent)
	{
	    ws.Agent $param_Agent_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_Agent_1 = (ws.Agent) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.leave($param_Agent_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 6: // shoot(Agent)
	{
	    ws.Agent $param_Agent_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_Agent_1 = (ws.Agent) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.shoot($param_Agent_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 7: // turnLeft(Agent)
	{
	    ws.Agent $param_Agent_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_Agent_1 = (ws.Agent) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.turnLeft($param_Agent_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 8: // turnRight(Agent)
	{
	    ws.Agent $param_Agent_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_Agent_1 = (ws.Agent) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.turnRight($param_Agent_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	case 9: // walk(Agent)
	{
	    ws.Agent $param_Agent_1;
	    try {
		java.io.ObjectInput in = call.getInputStream();
		$param_Agent_1 = (ws.Agent) in.readObject();
	    } catch (java.io.IOException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } catch (java.lang.ClassNotFoundException e) {
		throw new java.rmi.UnmarshalException("error unmarshalling arguments", e);
	    } finally {
		call.releaseInputStream();
	    }
	    server.walk($param_Agent_1);
	    try {
		call.getResultStream(true);
	    } catch (java.io.IOException e) {
		throw new java.rmi.MarshalException("error marshalling return", e);
	    }
	    break;
	}
	    
	default:
	    throw new java.rmi.UnmarshalException("invalid method number");
	}
    }
}
