package org.jellyfin.apiclient

import org.jellyfin.apiclient.api.client.KtorClient
import org.jellyfin.apiclient.discovery.DiscoveryService
import org.jellyfin.apiclient.model.ClientInfo
import org.jellyfin.apiclient.model.DeviceInfo
import org.jellyfin.apiclient.model.discovery.ServerVersion

class Jellyfin(
	private val options: JellyfinOptions
) {
	constructor(initOptions: JellyfinOptions.Builder.() -> Unit) : this(JellyfinOptions.build(initOptions))

	val discovery by lazy {
		DiscoveryService(this, options.discoverBroadcastAddressesProvider)
	}

	/**
	 * Create a new API instance to use in API services.
	 * The [clientInfo] and [deviceInfo] parameters are required when not passed as option in [JellyfinOptions].
	 * The [baseUrl] is only required when HTTP calls are made.
	 */
	fun createApi(
		baseUrl: String? = null,
		accessToken: String? = null,
		clientInfo: ClientInfo? = options.clientInfo,
		deviceInfo: DeviceInfo? = options.deviceInfo
	): KtorClient {
		checkNotNull(clientInfo) { "ClientInfo needs to be set when calling createApi() or by providing it when constructing the Jellyfin instance" }
		checkNotNull(deviceInfo) { "DeviceInfo needs to be set when calling createApi() or by providing it when constructing the Jellyfin instance" }

		return KtorClient(
			baseUrl,
			accessToken,
			clientInfo,
			deviceInfo
		)
	}

	companion object {
		val recommendedVersion = ServerVersion(10, 7, 0)
		val apiVersion = ServerVersion(10, 7, 0)
	}
}
