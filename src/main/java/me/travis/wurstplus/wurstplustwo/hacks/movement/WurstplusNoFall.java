package me.travis.wurstplus.wurstplustwo.hacks.movement;

import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPacket;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.network.play.client.CPacketPlayer;

public class WurstplusNoFall extends WurstplusHack {
	public WurstplusNoFall() {
        super(WurstplusCategory.WURSTPLUS_MOVEMENT);

		this.name        = "NoFall";
		this.tag         = "NoFall";
		this.description = "Protects from fall damage";
    }
	
	@EventHandler
    private Listener<WurstplusEventPacket.SendPacket> send_listener = new Listener<>(event -> {

        if (mc.player == null) return;
        
        if (mc.player.isElytraFlying()) return;
        
        if (mc.player.fallDistance < 3f) return;
        
        if (event.get_packet() instanceof CPacketPlayer) {
            CPacketPlayer packet = (CPacketPlayer) event.get_packet();
            packet.onGround = true;
        }
    });
}
