package me.travis.wurstplus.wurstplustwo.hacks.render;

import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventPacket;
import me.travis.wurstplus.wurstplustwo.event.events.WurstplusEventRender;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusCategory;
import me.travis.wurstplus.wurstplustwo.hacks.WurstplusHack;
import me.zero.alpine.fork.listener.EventHandler;
import me.zero.alpine.fork.listener.Listener;
import net.minecraft.network.play.server.SPacketTimeUpdate;

public class WurstplusAlwaysNight extends WurstplusHack {

    public WurstplusAlwaysNight() {
        super(WurstplusCategory.WURSTPLUS_RENDER);

        this.name = "Always Night";
        this.tag = "AlwaysNight";
        this.description = "see even less";
    }
    
    @EventHandler
    private Listener<WurstplusEventPacket.ReceivePacket> on_packet = new Listener<>(event -> {
    	if (mc.world == null) return;
        if (event.get_packet() instanceof SPacketTimeUpdate) {
        	SPacketTimeUpdate packet = (SPacketTimeUpdate) event.get_packet();
        	mc.world.setTotalWorldTime(packet.getTotalWorldTime());
        	event.cancel();
        }
    });
    
    @EventHandler
    private Listener<WurstplusEventRender> on_render = new Listener<>(event -> {
        if (mc.world == null) return;
        mc.world.setWorldTime(18000);
    });

    @Override
    public void update() {
        if (mc.world == null) return;
        mc.world.setWorldTime(18000);
    }
}
