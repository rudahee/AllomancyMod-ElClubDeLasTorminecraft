package common.legobmw99.allomancy.network.packets;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;

import common.legobmw99.allomancy.common.AllomancyData;
import common.legobmw99.allomancy.network.AbstractPacket;

public class AllomancyUpdateBurnPacket extends AbstractPacket {

	private int mat;
	private boolean value;
	AllomancyData data;

	public AllomancyUpdateBurnPacket(int mat, boolean value) {
		this.mat = mat;
		this.value = value;
	}

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		// TODO Auto-generated method stub
		buffer.writeInt(this.mat);
		buffer.writeBoolean(this.value);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		// TODO Auto-generated method stub
		this.mat = buffer.readInt();
		this.value = buffer.readBoolean();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		// TODO Auto-generated method stub
		this.data = AllomancyData.forPlayer(player);
		this.data.updateBurn(this.mat, this.value);
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		// TODO Auto-generated method stub
		this.data = AllomancyData.forPlayer(player);
		this.data.updateBurn(this.mat, this.value);
	}

}